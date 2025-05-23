package com.example.workclass.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainMenuScreen(navController:NavHostController){
Column(
    modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
) {
    Text("Main Menu")
    Button(
        onClick = { navController.navigate("home_screen")}

    ) {
        Text("Go to Home Screen")
    }
    Button(
        onClick = { navController.navigate("test_screen")}

    ) {
        Text("Go to Test Screen")
    }

    Button(
        onClick = { navController.navigate("interface_screen")}

    ) {
        Text("Go to Nike App")
    }
    Button(
        onClick = { navController.navigate("components_screen")}

    ) {
        Text("Go to Components Screens")
    }
    Button(
        onClick = { navController.navigate("Login_Screen")}

    ) {
        Text("Go to Login Screen")
    }
    Button(
        onClick = { navController.navigate("apiCamera")}

    ) {
        Text("Go to Api Camera")
    }
    Button(
        onClick = { navController.navigate("apiContactsCalendar")}

    ) {
        Text("Go to Contacts and calendar Api ")
    }
    Button(
        onClick = { navController.navigate("apiPush")}

    ) {
        Text("Go to Push notifications Api ")
    }
    Button(
        onClick = { navController.navigate("biometric_screen")}

    ) {
        Text("Go to Biometric Sensor")
    }
}
}