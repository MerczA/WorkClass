package com.example.workclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workclass.ui.screens.HomeScreen
import com.example.workclass.ui.screens.InterfazNike
import com.example.workclass.ui.screens.MainMenuScreen
import com.example.workclass.ui.screens.TestScreen
import com.example.workclass.ui.theme.WorkClassTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge() //
        setContent {
            WorkClassTheme {
                ComposeMultiScreenApp()

            }
        }
    }
} //CLOSE CLASS


@Composable
fun ComposeMultiScreenApp() { //La navegacion entre pantallas
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController) { //Es el que nos va mandar a la pantalla del menu que vamos a querer por medio de una ruta
    NavHost(navController = navController, startDestination = "interface_screen") {
        composable("main_menu") { MainMenuScreen(navController) }
        composable("home_screen") { HomeScreen(navController) }
        composable("test_screen") { TestScreen(navController) }
        composable("interface_screen") { InterfazNike(navController) }
    }
}










