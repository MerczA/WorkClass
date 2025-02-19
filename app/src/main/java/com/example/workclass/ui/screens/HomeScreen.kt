package com.example.workclass.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.workclass.R



@Composable
fun HomeScreen(navController: NavHostController){
    TopBar()
    Column(
        modifier = Modifier
            .padding(0.dp,60.dp,0.dp,0.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ContentOne()
        Content2()
        ContentOne()
        Content2()
        ContentOne()
        Content2()
        ContentOne()
        Content2()
    }
}


@Preview(showBackground = true)
@Composable
fun ContentOne (){
    Card (
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Text(
            text = "This is a Title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(R.drawable.logo_android),
            contentDescription = "Android Logo",
            contentScale = ContentScale.Crop

        )
        Text(
            stringResource(R.string.ejemplo),
            textAlign = TextAlign.Justify,
            lineHeight = 10.sp,
            modifier = Modifier.padding(10.dp)


            )
    }
}

@Preview(showBackground = true)
@Composable
fun Content2(){
    Card (
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Row (){

            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(100.dp),
                painter = painterResource(R.drawable.logo_android),
                contentDescription = "Android Logo",
                contentScale = ContentScale.Crop
            )
            Column (

            ){
                Text(
                    text = "This is a Title",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    stringResource(R.string.ejemplo),
                    textAlign = TextAlign.Justify,
                    lineHeight = 14.sp,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(10.dp)


                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TopBar(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Black)
            .padding(10.dp)

    ){
        Icon(
            Icons.Filled.Menu,
            contentDescription = "Menu Icon",
            tint = Color.White,
            modifier = Modifier
                .size(20.dp)
        )
        Text(
            stringResource(R.string.app_name),
            color = Color.White,
            fontSize = 17.sp
        )

    }






}