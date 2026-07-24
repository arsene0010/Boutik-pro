package com.boutikpro.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.boutikpro.app.BoutikViewModel
import com.boutikpro.app.data.Credit

@Composable
fun EcranCredits(navController: NavController, viewModel: BoutikViewModel) {
    val credits by viewModel.credits.collectAsState()
    Column(Modifier.padding(16.dp)) {
        Text("Gestion des Credits")
        credits.forEach { Text("${it.nomClient}: ${it.montant} FCFA") }
    }
}
