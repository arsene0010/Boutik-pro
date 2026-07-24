package com.boutikpro.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.boutikpro.app.data.Credit
import com.boutikpro.app.data.CreditDao
import com.boutikpro.app.data.Produit
import com.boutikpro.app.data.ProduitDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BoutikViewModel(
    private val produitDao: ProduitDao,
    private val creditDao: CreditDao
) : ViewModel() {

    private val _produits = MutableStateFlow<List<Produit>>(emptyList())
    val produits: StateFlow<List<Produit>> = _produits

    private val _credits = MutableStateFlow<List<Credit>>(emptyList())
    val credits: StateFlow<List<Credit>> = _credits

    private val _panier = MutableStateFlow<MutableList<Produit>>(mutableListOf())
    val panier: StateFlow<MutableList<Produit>> = _panier

    init {
        chargerProduits()
        chargerCredits()
    }

    fun chargerProduits() = viewModelScope.launch { _produits.value = produitDao.getAll() }
    fun chargerCredits() = viewModelScope.launch { _credits.value = creditDao.getAll() }

    fun ajouterAuPanier(produit: Produit) {
        _panier.value.add(produit)
        _panier.value = _panier.value.toMutableList() // Force recomposition
    }

    fun validerVente() {
        viewModelScope.launch {
            _panier.value.forEach { p ->
                val nouveauStock = p.quantite - 1
                produitDao.update(p.copy(quantite = nouveauStock))
            }
            _panier.value.clear()
            chargerProduits()
        }
    }

    fun ajouterCredit(credit: Credit) = viewModelScope.launch {
        creditDao.insert(credit)
        chargerCredits()
    }
}

class BoutikViewModelFactory(
    private val produitDao: ProduitDao,
    private val creditDao: CreditDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BoutikViewModel(produitDao, creditDao) as T
    }
}
