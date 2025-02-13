package com.example.workclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workclass.ui.screens.MainMenuScreen
import com.example.workclass.ui.theme.WorkClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge() //
        setContent {
            WorkClassTheme {

                ComposeMultiScreenApp()
                /*Column() {
                    Column() {
                        TextComposable("Roberto")
                        TextComposable()
                        TextComposable()
                        TextComposable()
                        TextComposable()
                    }
                    Row() {
                        TextComposable()
                        TextComposable()
                        TextComposable()
                        TextComposable()


                    }
                    Column (){
                        ModifierExample2()
                        ModifierExample4()
                        CustomText()
                        Picture()
                    }
                }*/
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TextComposable(name: String = "Empty") {
        Text("Welcome")
        Text(name)
    }
    @Preview (showBackground = true)
    @Composable
    fun ModifierExample1(){
        Column (
            modifier = Modifier
                .padding(40.dp,30.dp,20.dp,10.dp)
        ){
            Text("Hello World")
        }
    }
    @Preview (showBackground = true)
    @Composable
    fun ModifierExample2(){
        Column (
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .clickable (onClick = {clickAction() })
        ){
            Text("Hello World")
        }
    }


    fun clickAction (){
    println("Column Clicked")
    }

    @Preview (showBackground = true)
    @Composable
    fun ModifierExample3(){
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .background(Color.Cyan)
                .border(width = 2.dp,color=Color.Black)
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly


        ) {
            TextComposable("1")
            TextComposable("2")
            TextComposable("3")
            TextComposable("4")

        }



    }

    @Preview (showBackground = true)
    @Composable
    fun ModifierExample4() {
        Box (
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp)
                .width(300.dp)
                .height(300.dp)
        ){
            Text("1",Modifier.align(Alignment.TopStart))
            Text("2",Modifier.align(Alignment.TopCenter))
            Text("3",Modifier.align(Alignment.TopEnd))
            Text("4",Modifier.align(Alignment.CenterStart))
            Text("5",Modifier.align(Alignment.Center))
            Text("6",Modifier.align(Alignment.CenterEnd))
            Text("7",Modifier.align(Alignment.BottomStart))
            Text("8",Modifier.align(Alignment.BottomCenter))
            Text("9",Modifier.align(Alignment.BottomEnd))








        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CustomText(name: String = "Empty") {
    Column () {

        Text(
            stringResource(R.string.Sample_Text),
            color = colorResource(R.color.purple_500),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        val gradientColors = listOf(Color.Cyan,Color.Red, colorResource(R.color.purple_500))
        Text(
            stringResource(R.string.Sample_Text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))

            )
    }
    }
    @Preview(showBackground = true)
    @Composable
    fun Picture(){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .height(300.dp)
        ){
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(R.drawable.logo_android),
                contentDescription = "Logo ofiicial del Instituto Tecnologico de Aguascalientes",
                contentScale = ContentScale.Crop
            )
        }
    }


} //CLOSE CLASS


@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "main_menu"){
        composable("main_menu"){
            MainMenuScreen(navController)
        }
    }

}








