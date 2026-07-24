package com.boutikpro.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.boutikpro.app.BoutikViewModel

@Composable
fun EcranStock(navController: NavController, viewModel: BoutikViewModel) {
    val produits by viewModel.produits.collectAsState()
    LazyColumn(Modifier.padding(16.dp)) {
        items(produits) { p ->
            Text("${p.nom} - Stock: ${p.quantite} - ${p.prix} FCFA")
        }
    }
}
