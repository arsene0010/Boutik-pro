package com.boutikpro.app.data

import androidx.room.*

@Dao
interface ProduitDao {
    @Query("SELECT * FROM produits") suspend fun getAll(): List<Produit>
    @Insert suspend fun insert(produit: Produit)
    @Update suspend fun update(produit: Produit)
    @Query("SELECT * FROM produits WHERE codeBarre = :code LIMIT 1") suspend fun findByCode(code: String): Produit?
}

@Dao
interface CreditDao {
    @Query("SELECT * FROM credits") suspend fun getAll(): List<Credit>
    @Insert suspend fun insert(credit: Credit)
}
