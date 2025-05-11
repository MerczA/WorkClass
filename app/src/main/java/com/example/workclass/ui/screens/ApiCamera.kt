package com.example.workclass.ui.screens

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ApiCamera(navController: NavController) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    var hasCameraPermission by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) } // Para almacenar la URI de la imagen seleccionada

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasCameraPermission = granted
        if (!granted) {
            Toast.makeText(context, "Permiso de cámara denegado", Toast.LENGTH_SHORT).show()
        }
    }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        // Cuando se selecciona una imagen de la galería, actualiza la URI
        imageUri = uri
    }

    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.CAMERA)
    }

    // Si el permiso de cámara ha sido concedido, muestra la vista previa de la cámara
    if (hasCameraPermission) {
        CameraPreview(lifecycleOwner = lifecycleOwner)
    }

    // Botón para seleccionar imagen desde la galería
    Button(
        onClick = { galleryLauncher.launch("image/*") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Seleccionar Imagen de Galería")
    }

    // Si hay una imagen seleccionada, mostrarla
    imageUri?.let {
        Image(
            painter = rememberImagePainter(it),
            contentDescription = "Imagen seleccionada",
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun CameraPreview(lifecycleOwner: androidx.lifecycle.LifecycleOwner) {
    // Obtiene el contexto actual de la aplicación
    val context = LocalContext.current
    // Obtiene una instancia futura del proveedor de la cámara (ProcessCameraProvider)
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    // Crea una instancia de ImageCapture para capturar imágenes
    val imageCapture = remember { ImageCapture.Builder().build() }

    // Contenedor para la vista previa de la cámara y el botón de captura
    Column(modifier = Modifier.fillMaxSize()) {
        // Vista previa de la cámara usando AndroidView
        AndroidView(
            factory = { ctx ->
                // Crea una vista PreviewView para mostrar la vista previa de la cámara
                val previewView = PreviewView(ctx)
                // Agrega un listener para cuando el proveedor de la cámara esté listo
                cameraProviderFuture.addListener({
                    // Obtiene el proveedor de la cámara
                    val cameraProvider = cameraProviderFuture.get()
                    // Crea un objeto Preview y lo conecta a la vista de la cámara
                    val preview = Preview.Builder().build().also {
                        it.setSurfaceProvider(previewView.surfaceProvider)
                    }
                    // Selecciona la cámara trasera como la predeterminada
                    val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
                    try {
                        // Libera cualquier cámara previamente vinculada
                        cameraProvider.unbindAll()
                        // Vincula la cámara a la actividad/fragmento, junto con la vista previa y la captura de imagen
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner,
                            cameraSelector,
                            preview,
                            imageCapture
                        )
                    } catch (e: Exception) {
                        // Captura y muestra cualquier error al intentar iniciar la cámara
                        e.printStackTrace()
                        Toast.makeText(ctx, "Error al iniciar la cámara", Toast.LENGTH_SHORT).show()
                    }
                }, ContextCompat.getMainExecutor(ctx))
                // Devuelve la vista PreviewView que será renderizada
                previewView
            },
            modifier = Modifier
                .weight(1f) // Toma todo el espacio disponible
                .fillMaxWidth() // Asegura que ocupe todo el ancho de la pantalla
        )

        // Botón para tomar la foto
        Button(
            onClick = {
                // Llama a la función takePhoto() cuando se presiona el botón
                takePhoto(context, imageCapture)
            },
            modifier = Modifier
                .fillMaxWidth() // Asegura que el botón ocupe todo el ancho disponible
                .padding(16.dp) // Añade espacio alrededor del botón
        ) {
            // Texto del botón
            Text("Tomar Foto")
        }
    }
}


fun takePhoto(context: Context, imageCapture: ImageCapture) {
    // Genera un nombre único para la foto basado en la fecha y hora actual
    val name = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        .format(System.currentTimeMillis())

    // Crea un ContentValues que contiene la metadata de la imagen a guardar
    val contentValues = ContentValues().apply {
        // Establece el nombre de la imagen en el almacenamiento
        put(MediaStore.MediaColumns.DISPLAY_NAME, name)
        // Establece el tipo MIME de la imagen (JPEG)
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        // Si la versión de Android es >= Q, establece la ruta relativa de la imagen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            put(MediaStore.Images.Media.RELATIVE_PATH, "DCIM/CameraX")
        }
    }

    // Prepara las opciones para guardar la imagen en el almacenamiento externo
    val outputOptions = ImageCapture.OutputFileOptions
        .Builder(
            context.contentResolver, // Usamos el contentResolver para interactuar con el almacenamiento
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, // URI del almacenamiento externo
            contentValues // Metadata de la imagen
        )
        .build()

    // Toma la foto y guarda la imagen usando las opciones preparadas
    imageCapture.takePicture(
        outputOptions, // Opciones de salida donde se guarda la imagen
        ContextCompat.getMainExecutor(context), // Ejecuta en el hilo principal
        object : ImageCapture.OnImageSavedCallback { // Callback que se invoca cuando la imagen es guardada o ocurre un error
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                // Si la foto fue guardada correctamente, muestra un mensaje de éxito
                Toast.makeText(context, "Foto guardada en galería", Toast.LENGTH_SHORT).show()
            }

            override fun onError(exception: ImageCaptureException) {
                // Si ocurre un error al guardar la foto, imprime el error y muestra un mensaje al usuario
                exception.printStackTrace()
                Toast.makeText(context, "Error al guardar foto", Toast.LENGTH_SHORT).show()
            }
        }
    )
}
