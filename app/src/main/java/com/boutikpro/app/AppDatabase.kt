package com.boutikpro.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.boutikpro.app.data.Credit
import com.boutikpro.app.data.CreditDao
import com.boutikpro.app.data.Produit
import com.boutikpro.app.data.ProduitDao

@Database(entities = [Produit::class, Credit::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun produitDao(): ProduitDao
    abstract fun creditDao(): CreditDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "boutik_db").build()
                    .also { INSTANCE = it }
            }
        }
    }
}
