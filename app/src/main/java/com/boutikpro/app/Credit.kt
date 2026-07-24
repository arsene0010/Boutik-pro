package com.boutikpro.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credits")
data class Credit(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nomClient: String,
    val telephone: String,
    val montant: Double,
    val date: Long = System.currentTimeMillis()
)
