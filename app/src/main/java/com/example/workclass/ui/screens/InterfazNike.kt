package com.example.workclass.ui.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.workclass.R


@Composable
fun InterfazNike(navController: NavHostController) {
        Column(
            modifier = Modifier
                .padding(0.dp, 15.dp, 0.dp, 0.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) //Para poder tener scroll de manera vertical
        ) {
            TopBarNike() //Le llamamaos a la funcion TopBar
            Box(//Utilizamos un Box para que el menuIcons Podamos ajustar su padding y ponerlo mas al centro
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                MenuIcons() //Llamamaos a la funcion de MenuIcons
            }
            BarraCat()
            Text(
                "Lo mejor de Member Days Hombre",
                fontSize = 20.sp, //Tamaño de la letra
                modifier = Modifier
                    .padding(25.dp,0.dp,0.dp,0.dp)
            )
            Box(//Utilizamos un Box para mover el texto que estara debajo de las categorias
                modifier = Modifier
                    .padding(25.dp,0.dp,0.dp,0.dp)// Utilizamos solo la primera seccion que es la parte de la izquierda
            ){
                Discount()
            }
            Row {
                Text( //Titulo para categoria de tenis
                    "Eleva tu Outfit",
                    fontSize = 20.sp, //Tamaño de la letra
                    modifier = Modifier
                        .padding(25.dp,0.dp,220.dp,0.dp)
                )
                Text( //Titulo para categoria de tenis
                    "Ver todos",
                    fontSize = 15.sp, //Tamaño de la letra
                    modifier = Modifier
                        .padding(25.dp,0.dp,0.dp,0.dp)
                )
            }
            Box(//Utilizamos un Box para mover el texto que estara debajo de las categorias
                modifier = Modifier
                    .padding(25.dp,0.dp,0.dp,0.dp)// Utilizamos solo la primera seccion que es la parte de la izquierda
            ){
                ApartadoTenis()
            }

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(700.dp),
                painter = painterResource(R.drawable.imafull), //Imagen de hombre con caja de tenis
                contentDescription = "Android Logo",
                contentScale = ContentScale.Crop

            )
            Column (

            ){
                Text( //Titulo para collage Members Days
                    "Solo por Members Days",
                    fontSize = 20.sp, //Tamaño de la letra
                    modifier = Modifier
                        .padding(25.dp,40.dp,0.dp,0.dp)
                )

                Text( //Titulo para collage Members Days
                    "No dejes pasar esta oportunidad",
                    fontSize = 20.sp, //Tamaño de la letra
                    modifier = Modifier
                        .padding(25.dp,3.dp,0.dp,0.dp)
                )
            }
            ApartadoMembersDays()
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarNike(){
    Column {

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(30.dp,0.dp,0.dp,0.dp)
        ){
            Icon(
                Icons.Filled.Menu,
                contentDescription = "Menu Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(25.dp)
            )
            Text(
                text = "Comprar",
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(30.dp,0.dp,245.dp,0.dp)
            )
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search",
                tint = Color.Black,
                modifier = Modifier
                    .size(25.dp)
                    .padding(0.dp,0.dp,3.dp,0.dp)
            )
            Icon(
                Icons.Filled.ShoppingCart,
                contentDescription = "Menu Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(25.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuIcons() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray)
            .size(width = 100.dp, height = 40.dp)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Filled.Person,
            contentDescription = "Menu Icon",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
        )
        Icon(
            Icons.Filled.Menu,
            contentDescription = "Menu Icon",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BarraCat(){ //Categorias entre Man,Woman and kids
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp,5.dp,0.dp,0.dp)
        ){
            Text(
                stringResource(R.string.Men),//Categoria de Hombre
                color = Color.Black,
                fontSize = 17.sp,
                modifier = Modifier
                    .padding(30.dp,0.dp,0.dp,0.dp)
                    .clickable (onClick = {clickAction() }
                    )
            )
            Row {
                Text(
                    stringResource(R.string.Woman), //Categoria de Mujeres
                    color = Color.Black,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .padding(30.dp,0.dp,0.dp,30.dp)
                        .clickable (onClick = {clickAction() }
                        )
                        )
                Text(
                    stringResource(R.string.Kids), // Categoria de Niño/a
                    color = Color.Black,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .padding(30.dp,0.dp,0.dp,30.dp)
                        .clickable (onClick = {clickAction() }
                        )
                        )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Discount(){
    Row {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color.Transparent)
            .height(270.dp)
            .padding(12.dp,20.dp,20.dp,20.dp)
            .horizontalScroll(rememberScrollState())
    ){

        Row (
        ){
            Column { Image(
                painter = painterResource(R.drawable.img_1), //Imagen del 30% de descuento
                contentDescription = "Imagen de 30% de descuento",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable (onClick = {clickAction() })
                    .width(200.dp)
                    .height(200.dp)
                    .padding(5.dp)
                    .border(1.dp, Color.Black, shape = RectangleShape), // Agrega un borde negro y redondo
            )
                Text("Hasta 30% de descuento",
                    modifier = Modifier
                        .padding(3.dp,0.dp,0.dp,0.dp)

                )

            }
            Column {
                Image(
                    painter = painterResource(R.drawable.img_4), //Imagen del 20% de descuento
                    contentDescription = "Imagen de 20% de descuento",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable (onClick = {clickAction() })
                        .width(200.dp)
                        .height(200.dp)
                        .padding(5.dp)
                        .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
                )
                Text("Hasta 20% de descuento",
                    modifier = Modifier
                        .padding(3.dp,0.dp,0.dp,0.dp)
                )
            }
            Column {
                Image(
                    painter = painterResource(R.drawable.img_3),//Imagen de meses sin intereses
                    contentDescription = "Imagen de 9 meses sin intereses",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable (onClick = {clickAction() })
                        .width(200.dp)
                        .height(200.dp)
                        .padding(5.dp)
                        .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
                )
                Text("Meses sin intereses ",
                    modifier = Modifier
                        .padding(3.dp,0.dp,3.dp,0.dp)
                )
            }

           Column { Image(
               painter = painterResource(R.drawable.img_2),//Imagen hombre
               contentDescription = "Imagen de hombre",
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .clickable (onClick = {clickAction() })
                   .width(200.dp)
                   .height(200.dp)
                   .padding(5.dp)
                   .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
           )
               Text("El toque que tu estilo necesita",
                   modifier = Modifier
                       .padding(3.dp,0.dp,0.dp,0.dp)
               )

           }

            Column {
                Image(
                    painter = painterResource(R.drawable.img_6),//Imagen de hombre corriendo
                    contentDescription = "Hombre corriendo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable (onClick = {clickAction() })
                        .width(200.dp)
                        .height(200.dp)
                        .padding(5.dp)
                        .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
                )
                Text("Rompe tu marca personal",
                    modifier = Modifier
                        .padding(3.dp,0.dp,0.dp,0.dp)
                )
            }

           Column {
               Image(
                   painter = painterResource(R.drawable.img_5),
                   contentDescription = "Hombre haciendo ejercicio",
                   contentScale = ContentScale.Crop,
                   modifier = Modifier
                       .clickable (onClick = {clickAction() })
                       .width(200.dp)
                       .height(200.dp)
                       .padding(5.dp)
                       .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
               )
               Text("Entrena con lo mejor",
                   modifier = Modifier
                       .padding(3.dp,0.dp,0.dp,0.dp)
               )
           }
            Column {

                Image(
                    painter = painterResource(R.drawable.img_7),//Logo futbol
                    contentDescription = "Hombre practicando deporte",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable (onClick = {clickAction() })
                        .width(200.dp)
                        .height(200.dp)
                        .padding(5.dp)
                        .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
                )
                Text("Domina la cancha",
                    modifier = Modifier
                        .padding(3.dp,0.dp,0.dp,0.dp)
                )

            }

        }}
    }
}

@Preview(showBackground = true)
@Composable
fun ApartadoTenis(){
    Row {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .height(280.dp)
                .padding(12.dp,20.dp,20.dp,20.dp)
                .horizontalScroll(rememberScrollState())
        ){

            Row (

            ){
                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis1), //Imagen primer par de tenis
                        contentDescription = "Imagen de par de tenis",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                            .border(1.dp, Color.Black, shape = RectangleShape), // Agrega un borde negro y redondo
                    )
                    Text("Air Jordan Legacy 321 Low",
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )
                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis2), //Imagen del 20% de descuento
                        contentDescription = "Imagen de 20% de descuento",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                            .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
                    )
                    Text("Lebron TR1",
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )
                }

                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis3),//Imagen de meses sin intereses
                        contentDescription = "Imagen de 9 meses sin intereses",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                            .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
                    )
                    Text("Air Jordan 1 Low",
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )
                }

                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis4),//Imagen hombre
                        contentDescription = "Imagen de hombre",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                            .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
                    )
                    Text("Nike Air Force 1 Retro",
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )
                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis5),//Imagen de hombre corriendo
                        contentDescription = "Hombre corriendo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                            .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
                    )
                    Text("Nike Zoom Vomero Roam",
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )

                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis6),
                        contentDescription = "Hombre haciendo ejercicio",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                            .border(1.dp, Color.Black, shape = RectangleShape) // Agrega un borde negro y redondo
                    )
                    Text("Nike V2K Run",
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ApartadoMembersDays(){
    Row {
        Column(

        ) { Text("Hola") }
        Column (

        ){ Text("Hola 2") }
        Column (

        ){ Text("Hola 3") }


    }

}




