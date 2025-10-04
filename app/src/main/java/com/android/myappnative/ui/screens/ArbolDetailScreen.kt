package com.android.myappnative.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.myappnative.data.Arbol
import com.android.myappnative.data.ArbolData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArbolDetailScreen(navController: NavController, arbol: Arbol, modifier: Modifier = Modifier) {

    val arbol = ArbolData.findById(arbol.arbolId)
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                ),
                title = { Text("Detalle del Árbol") }

            )
        }
    ) { padding ->
        if (arbol != null) {
           Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = arbol.icon),
                    contentDescription = arbol.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = arbol.name, style = MaterialTheme.typography.titleLarge)
               arbol.detail?.let { Text(text = it, style = MaterialTheme.typography.bodyMedium) }
            }
        } else {
            Text("Árbol no encontrado")
        }
    }}