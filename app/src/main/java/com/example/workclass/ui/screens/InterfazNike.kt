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
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
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
                .verticalScroll(rememberScrollState()) //Para poder tener scroll de manera vertical dentro de la aplicacion
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

            Divider(color = Color.LightGray, thickness = 2.dp, //Nueva funcion o elemento Divider
                modifier = Modifier
                    .padding(0.dp,0.dp,0.dp,0.dp))

            Text(
                "Lo mejor de Member Days Hombre",
                fontSize = 20.sp, //Tamaño de la letra
                modifier = Modifier
                    .padding(25.dp,10.dp,0.dp,0.dp)
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

                Text( //Titulo alineado a la izquierda para ver todos
                    "Ver todos",
                    fontSize = 15.sp, //Tamaño de la letra
                    modifier = Modifier
                        .padding(25.dp,0.dp,0.dp,0.dp)
                        .clickable (onClick = {clickAction() })

                )
            }
            Box(//Utilizamos un Box para mover el texto que estara debajo de las categorias
                modifier = Modifier
                    .padding(25.dp,0.dp,0.dp,0.dp)// Utilizamos solo la primera seccion que es la parte de la izquierda
            ){
                ApartadoTenis() //Nos muestra la funcion de apartado de tenis
            }

            Image( //Imagen que representa un catalogo no tiene funcionalidad
                modifier = Modifier
                    .fillMaxWidth()
                    .height(700.dp),
                painter = painterResource(R.drawable.imafull), //Imagen de hombre con caja de tenis
                contentDescription = "Imagen de catalogo",
                contentScale = ContentScale.Crop //Con el Crop se ajusta la imagen a todo el ancho de la pagina

            )
            Column ( //Utilizamos un column para que muestre los dos textos uno debajo de otro
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
            //Muestra las dos funciones que son el menu de 6 productos 3 por cada funcion
            ApartadoMembersDays()
            ApartadoMembersDays2()
            BotonFinal(navController)
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
            Icon( //Icono de menu
                Icons.Filled.Menu,
                contentDescription = "Menu Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(25.dp)
            )
            Text(
                text = "Comprar", //Titulo superior
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(30.dp,0.dp,245.dp,0.dp)
            )
            Icon(
                Icons.Filled.Search, //Icono de busqueda
                contentDescription = "Search",
                tint = Color.Black,
                modifier = Modifier
                    .size(25.dp)
                    .padding(0.dp,0.dp,3.dp,0.dp)
            )
            Icon(
                Icons.Filled.ShoppingCart, //Icono carrito de compra
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
            .clip(RoundedCornerShape(20.dp)) //Funcion para redondear los bordes
            .background(Color.LightGray)
            .size(width = 100.dp, height = 40.dp)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically, //Usamos estas funciones para centrar los dos iconos
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Filled.Check, //Icono de paloma simulando la de Nike
            contentDescription = "Menu Icon",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
                .padding(0.dp,0.dp,6.dp,0.dp)
        )
        Icon(
            Icons.Filled.ThumbUp, //Icono que seria el de Jordan
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
                .padding(5.dp,0.dp,0.dp,0.dp)
        ){
            Text(
                stringResource(R.string.Men),//Categoria de Hombre desde Drawable
                color = Color.Black,
                fontSize = 17.sp,
                modifier = Modifier
                    .padding(30.dp,0.dp,0.dp,0.dp)
                    .clickable (onClick = {clickAction() }
                    )
            )
            Row {
                Text(
                    stringResource(R.string.Woman), //Categoria de Mujeres desde Drawable
                    color = Color.Black,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .padding(30.dp,0.dp,0.dp,30.dp)
                        .clickable (onClick = {clickAction() }
                        )
                        )
                Text(
                    stringResource(R.string.Kids), // Categoria de Niño/a desde Drawable
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
                        contentDescription = "Imagen de par de tenis Air Jordan Legacy 321 Low",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                    )
                    Text("Air Jordan Legacy 321 Low \n$2,899",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )
                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis2), //Imagen segundo par de tenis
                        contentDescription = "Imagen de tenis Lebron TR1",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                    )
                    Text("Lebron TR1 \n$3,899",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )


                }

                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis3),//Imagen tercer par de tenis
                        contentDescription = "Imagen de tenis Air Jordan 1 Low",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                    )
                    Text("Air Jordan 1 Low\n$4,499",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )

                }

                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis4),//Imagen cuarto par de tenis
                        contentDescription = "Imagen de tenis Nike Air Force 1 Retro ",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                    )
                    Text("Nike Air Force 1 Retro\n$2,899",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )

                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis5),//Imagen quinto par de tenis
                        contentDescription = "Imagen de tenis Nike Zoom Vomero Roam",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                    )
                    Text("Nike Zoom Vomero Roam\n$1,999",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )


                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.tenis6),//Imagen sexto par de tenis
                        contentDescription = "Imagen de tenis Nike V2K Run",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(200.dp)
                            .height(200.dp)
                            .padding(5.dp)
                    )
                    Text("Nike V2K Run\n$5,899",
                        fontSize = 15.sp,
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
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .height(220.dp)
                .padding(20.dp,20.dp,20.dp,0.dp)
        ){

            Row (
            ){
                Column { Image(
                    painter = painterResource(R.drawable.mg1),
                    contentDescription = "Nike Mercurial",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable (onClick = {clickAction() })
                        .width(150.dp)
                        .height(150.dp)
                        .padding(1.dp)
                )
                    Text("Nike Mercurial \n$1,689",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,6.dp,0.dp)

                    )

                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.mg2),
                        contentDescription = "Nike Mercurial Super ",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(150.dp)
                            .height(150.dp)
                            .padding(1.dp)
                    )
                    Text("Nike Mercurial Super \n$1,689",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,2.dp,0.dp)
                    )

                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.mg3),
                        contentDescription = "Nike Free Metcon",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(150.dp)
                            .height(150.dp)
                            .padding(1.dp)
                    )
                    Text("Nike Free Metcon 6 \n$1,884",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,3.dp,0.dp)
                    )
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ApartadoMembersDays2(){
    Row {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .background(Color.Transparent)
                .height(270.dp)
                .padding(20.dp,2.dp,20.dp,0.dp)
        ){

            Row (
            ){
                Column { Image(
                    painter = painterResource(R.drawable.mg4),
                    contentDescription = "Nike Zoom GP",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable (onClick = {clickAction() })
                        .width(150.dp)
                        .height(150.dp)
                        .padding(2.dp)
                )
                    Text("Nike Zoom GP... \n$2,534",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)

                    )

                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.mp5),
                        contentDescription = "Nike Air Max 90",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(150.dp)
                            .height(150.dp)
                            .padding(2.dp)
                    )
                    Text("Nike Air Max 90 \n$1,949",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,0.dp,0.dp)
                    )
                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.mp6),
                        contentDescription = "Nike Rise 365",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable (onClick = {clickAction() })
                            .width(150.dp)
                            .height(150.dp)
                            .padding(2.dp)
                    )
                    Text("Nike Rise 365 \n$746 ",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(3.dp,0.dp,3.dp,0.dp)
                    )
                }


            }
        }
    }
}

@Composable
fun BotonFinal(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate("interface_screen") }
        ) {
            Text("Ver Todo")
        }
    }

}








