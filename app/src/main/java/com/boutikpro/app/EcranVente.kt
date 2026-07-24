package com.boutikpro.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boutikpro.app.BoutikViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranVente(navController: NavController, viewModel: BoutikViewModel) {
    val panier by viewModel.panier.collectAsState()
    val total = panier.sumOf { it.prix }
    
    Scaffold(topBar = { TopAppBar(title = { Text("Vente") }) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Button(onClick = { navController.navigate("scanner") }) { Text("Scanner un produit") }
            Spacer(Modifier.height(16.dp))
            Text("Panier: ${panier.size} articles")
            Text("Total: $total FCFA")
            Spacer(Modifier.height(16.dp))
            Button(onClick = { viewModel.validerVente() }) { Text("Valider et Payer") }
        }
    }
}
