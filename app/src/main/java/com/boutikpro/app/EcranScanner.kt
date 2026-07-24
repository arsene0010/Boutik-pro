package com.boutikpro.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.boutikpro.app.BoutikViewModel

@Composable
fun EcranScanner(navController: NavController, viewModel: BoutikViewModel) {
    // Version simple pour test. On integrera ZXing apres
    Column(Modifier.padding(16.dp)) {
        Text("Scanner Code Barre")
        Button(onClick = { navController.popBackStack() }) { Text("Retour") }
    }
}
