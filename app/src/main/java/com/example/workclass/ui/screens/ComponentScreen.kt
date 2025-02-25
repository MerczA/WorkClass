package com.example.workclass.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ComponentScreen(navController: NavHostController){
//buttons()
    //FloatingButtons()
    //Progress()
    //Chips()
    Sliders()
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

@Preview(showBackground = true)
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