package com.example.workclass.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.workclass.R


@Composable
fun InterfazNike(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(0.dp,15.dp,0.dp,0.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TopBarNike()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)

        ){
            MenuIcons()

        }
        BarraCat()
    }
}



@Preview(showBackground = true)
@Composable
fun TopBarNike(){
    Column {

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)

        ){
            Icon(
                Icons.Filled.Menu,
                contentDescription = "Menu Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(22.dp)
            )
            Text(
                text = "Comprar",
                color = Color.Black,
                fontSize = 17.sp,
                modifier = Modifier
                    .padding(30.dp,0.dp,180.dp,0.dp)


            )
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search",
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
                    .padding(0.dp,0.dp,3.dp,0.dp)
            )
            Icon(
                Icons.Filled.ShoppingCart,
                contentDescription = "Menu Icon",
                tint = Color.Black,

                modifier = Modifier
                    .size(20.dp)

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
            .background(Color.Gray)
            .size(width = 100.dp, height = 40.dp)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {
        Icon(
            Icons.Filled.Check,
            contentDescription = "Menu Icon",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.jordan),
            contentDescription = "Menu Icon",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BarraCat(){
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp,5.dp,0.dp,0.dp)
        ){
            Text(
                stringResource(R.string.Men),
                color = Color.Black,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(30.dp,0.dp,0.dp,0.dp)
            )
            Row {
                Text(
                    stringResource(R.string.Woman),
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(30.dp,0.dp,0.dp,30.dp)

                )
                Text(
                    stringResource(R.string.Kids),
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(30.dp,0.dp,0.dp,30.dp)

                )
            }
        }
    }
}