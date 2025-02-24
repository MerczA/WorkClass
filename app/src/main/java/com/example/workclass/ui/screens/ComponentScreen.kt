package com.example.workclass.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ComponentScreen(navController: NavHostController){
buttons()

}
@Preview(showBackground = true)
@Composable
fun buttons(){
    Column(
        modifier = Modifier
            .fillMaxSize(), //Para que ocupe el 100% de mi pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {}) {
            Text("Filled")
        }
        FilledTonalButton(onClick = {}) {
            Text("TonalButton")
        }
        OutlinedButton (onClick = {}) {
            Text("OutLine")
        }
        ElevatedButton(onClick = {}) {
            Text("ElevatedButton")
        }
        TextButton (onClick = {}) {
            Text("Text")
        }
    }
}