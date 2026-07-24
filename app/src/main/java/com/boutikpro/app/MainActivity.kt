package com.boutikpro.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boutikpro.app.ui.EcranCredits
import com.boutikpro.app.ui.EcranScanner
import com.boutikpro.app.ui.EcranStock
import com.boutikpro.app.ui.EcranVente

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AppDatabase.getDatabase(this)
        val viewModelFactory = BoutikViewModelFactory(db.produitDao(), db.creditDao())
        val viewModel = ViewModelProvider(this, viewModelFactory)[BoutikViewModel::class.java]

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "vente") {
                composable("vente") { EcranVente(navController, viewModel) }
                composable("stock") { EcranStock(navController, viewModel) }
                composable("credits") { EcranCredits(navController, viewModel) }
                composable("scanner") { EcranScanner(navController, viewModel) }
            }
        }
    }
}
