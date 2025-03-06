package com.example.workclass.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.workclass.data.model.MenuModel
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ComponentScreen(navController: NavHostController){
    val menuOptions = arrayOf(
        MenuModel(1,"Buttons","option1",Icons.Filled.AccountBox),
        MenuModel(2,"Floating Buttons","option2",Icons.Filled.Call),
        MenuModel(3,"Chips","option3",Icons.Filled.Star),
        MenuModel(3,"Sliders","option4",Icons.Filled.DateRange),
        MenuModel(3,"Switches","option5",Icons.Filled.PlayArrow),
        MenuModel(3,"Badges","option6",Icons.Filled.Warning),
        MenuModel(3,"Snack Bar","option7",Icons.Filled.MailOutline),
        MenuModel(3,"Alert Dialogs","option8",Icons.Filled.ThumbUp)
    )

    var option by rememberSaveable { mutableStateOf("") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)//
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items( menuOptions) { item ->
                        NavigationDrawerItem(
                            icon = { Icon(item.icon, contentDescription = "") },
                            label = { Text(item.title) },
                            selected = false,
                            onClick = {
                                option = item.option
                                scope.launch {
                                    drawerState.apply {
                                        close()
                                    }
                                }
                            }
                        )
                    }
                }

            }
        }
    ) {
        Column {
            when(option){
                "option1" -> {
                    buttons()
                }
                "option2" -> {
                    FloatingButtons()
                }
                "option3" -> {
                    Progress()
                }
                "option4" -> {
                    Chips()
                }
                "option5" -> {
                    Sliders()
                }
                "option6" -> {
                    Switches()
                }
                "option7" -> {
                    Badges()
                }
                "option8" -> {
                    SnackBars()
                }
                "option9" -> {
                    AlertDialogs()
                }


            }
        }
    }
}
//@Preview(showBackground = true)
@Composable
fun buttons(){
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {}) {//Boton ajustado al tamaño del texto
            Text("Filled")
        }
        FilledTonalButton(onClick = {}) {
            Text("TonalButton")
        }
        OutlinedButton (onClick = {}) { //Boton con solo contornos
            Text("OutLine")
        }
        ElevatedButton(onClick = {}) {//Boton con relleno
            Text("ElevatedButton")
        }
        TextButton (onClick = {}) {//Boton con solo Texto
            Text("Text")
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun FloatingButtons(){
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        FloatingActionButton(
            onClick = {}
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")

        }
        SmallFloatingActionButton (
            onClick = {}
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")

        }
        LargeFloatingActionButton (
            onClick = {}
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")

        }
        ExtendedFloatingActionButton( //Boton rectangular
            onClick = {}
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
            Text("Button")

        }


    }
    }

//@Preview(showBackground = true)
@Composable
fun Progress() { //Indicadores de progreso
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )

    }
}

//@Preview(showBackground = true)
@Composable
fun Chips() { //Acciones rapidas
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AssistChip(
            onClick = {},
            label = { Text("Assist Chip")},
            leadingIcon =  {
                Icon(Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)) //Para que se ajuste al texto y al icono
            }
        )
        var selected by remember { mutableStateOf(false) } //mutableStateOf nos permite que se mantenga el valor de mi variable aunque haga un refresh
        FilterChip(
            selected = selected, //Para saber si el filtro esta activo o no (true o false)
            onClick = {selected= !selected},//Al momento de darle click cambia de valor si estaba en falso cambia a verdadero y al reves
            label = { Text("Filter chip ")},
            leadingIcon =  if (selected) {
                {
                    Icon(
                        Icons.Filled.AccountBox,
                        contentDescription = "Filter Chip",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    ) //Para que se ajuste al texto y al icono
                }
            } else {
                null
            }


        )
        InputChipExample("Dismiss",{})



        }
    }

@Composable
fun InputChipExample(
    text: String,
    OnDismiss: () -> Unit
){
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return
    InputChip(
        label = { Text(text)},
        selected = enabled,
        onClick = {
            OnDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )


        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )

        }


    )


}

//@Preview(showBackground = true)
@Composable
fun Sliders() { //Barra con porcentaje y modificable
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        var sliderposition by remember { mutableStateOf(50f) }
        Slider(
            value = sliderposition,
            onValueChange = {sliderposition = it }, //Nos permite que la variable se actualiza conforme con la interaccion del usuario
            steps = 10,
            valueRange = 0f .. 100f
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = sliderposition.toString()
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Switches() { //Barra con porcentaje y modificable
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var checked by remember { mutableStateOf(true) }
        Switch( //Switch que nos ayuda a saber si una opcion esta habilitada o no
            checked = checked,
            onCheckedChange = {checked = it }
        )

        var checked2 by remember { mutableStateOf(true) }
        Switch(//Switch que nos ayuda a saber si una opcion esta habilitada o no con un icono de una palomita dentro
            checked = checked2,
            onCheckedChange = {checked2 = it },
            thumbContent = if(checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Switch Check",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }else {
                null
                }
        )
        var checked3 by remember { mutableStateOf(true) }

        Checkbox( //Boton para marcar si se completo una tarea
            checked =  checked3,
            onCheckedChange = {checked3 = it}
        )

    }
    }

//@Preview(showBackground = true)
@Composable
fun Badges() { //Indicadores de notificaciones
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
       var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0 ){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White

                    ){
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping cart icon"
            )

        }
        Button(
            onClick = {itemCount++}
        ) {
            Text("Add item")
        }
    }


    }

//@Preview(showBackground = true)
@Composable
fun SnackBars() { //Barra de notificacion
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The message has been sent") }
        }
        Button(
            ::launchSnackBar //Dos puntos para mandar a hablar e la funcion pero solo con los (::) en el inicio
        ) {
            Text("Send message")
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)//Api
@Preview(showBackground = true)
@Composable
fun AlertDialogs() { //Mensaje como notificacion con confirmacion por ejemplo si queremos borrar un archivo
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if (showAlertDialog){
            AlertDialog(
                icon = {Icon(Icons.Filled.Warning, contentDescription = "Warning Icon")},
                title = { Text("Confirm Deletion")},
                text = { Text("Are you sure you want to delete the file?")},
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirmed"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Yes")
                    }
                },
                        dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Canceled"
                            showAlertDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }
        Button(onClick = { showAlertDialog = true}) {
            Text("Delete File")
        }

        Text(selectedOption)




    }
}
