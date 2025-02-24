package com.example.workclass.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ComponentScreen(navController: NavHostController){
//buttons()
    //FloatingButtons()
    Progress()

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

@Preview(showBackground = true)
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