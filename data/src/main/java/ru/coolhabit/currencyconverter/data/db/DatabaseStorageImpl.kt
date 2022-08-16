package ru.coolhabit.currencyconverter.data.db

import android.content.Context
import androidx.room.Room
import ru.coolhabit.currencyconverter.core.api.IDatabaseStorage
import ru.coolhabit.currencyconverter.data.db.entities.toData
import ru.coolhabit.currencyconverter.data.db.entities.toDomain
import ru.coolhabit.currencyconverter.entities.dto.Currency

class DatabaseStorageImpl(context: Context) : IDatabaseStorage {

    private val database: AppDatabase =
        Room
            .databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration().build()

    override suspend fun addCurrencyToFav(currency: Currency) {
        database.currencyDao().insert(currency.toData())
    }

    override suspend fun removeCurrencyFromFav(currency: Currency) {
        database.currencyDao().delete(currency.toData())
    }

    override suspend fun getFavouriteCurrency(): List<Currency> {
        return database.currencyDao().getFavouriteHeroes().map { it.toDomain() }
    }
}
