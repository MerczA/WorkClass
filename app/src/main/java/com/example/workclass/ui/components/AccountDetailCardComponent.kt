package com.example.workclass.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.workclass.R


@Composable
fun AccountDetailCardComponent(
    id: Int,
    name: String,
    username: String,
    password: String,
    imageURL: String,
    description: String,
    onSaveClick: () -> Unit,
    navController: NavController,

    ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current

        AsyncImage(
            model = imageURL,
            contentDescription = "Account Logo",
            contentScale = ContentScale.Fit,
            error = painterResource(R.drawable.logo_android),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )

        // 🔽 Fila de botones: Guardar y Editar
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                onSaveClick()
                Toast.makeText(context, "Guardado como favorito", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Save as Favorite",
                )
            }

            IconButton(onClick = {
                navController.navigate("manage_account_screen?id=$id")
            }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Account"
                )
            }

        }
    }



    Spacer(modifier = Modifier.height(16.dp))

        InfoRow(title = "Account", value = name)
        InfoRow(title = "Username", value = username, showIcon = true)
        InfoRow(title = "Password", value = password, showIcon = true)
        InfoRow(title = "Description", value = description)
    }




@Composable
fun InfoRow(title: String, value: String, showIcon: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$title:",
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            modifier = Modifier.weight(2f)
        )
        if (showIcon) {
            IconButton(onClick = {
            }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Action"
                )
            }
        }
    }
}
