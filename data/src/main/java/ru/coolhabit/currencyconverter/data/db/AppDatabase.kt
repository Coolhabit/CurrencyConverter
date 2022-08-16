package ru.coolhabit.currencyconverter.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.coolhabit.currencyconverter.data.db.AppDatabase.Companion.DATABASE_VERSION
import ru.coolhabit.currencyconverter.data.db.dao.CurrencyDao
import ru.coolhabit.currencyconverter.data.db.entities.CurrencyDB

@Database(entities = [CurrencyDB::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao

    companion object {
        const val DATABASE_NAME = "currency_db"
        const val DATABASE_VERSION = 1
    }
}
