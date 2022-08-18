package ru.coolhabit.currencyconverter.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.coolhabit.currencyconverter.data.db.AppDatabase.Companion.DATABASE_NAME
import ru.coolhabit.currencyconverter.data.db.entities.CurrencyDB

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currency: CurrencyDB)

    @Delete
    suspend fun delete(currency: CurrencyDB)

    @Query("SELECT * FROM $DATABASE_NAME")
    suspend fun getFavouriteHeroes(): List<CurrencyDB>
}
