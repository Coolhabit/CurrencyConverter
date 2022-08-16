package ru.coolhabit.currencyconverter.data.db

import android.content.Context
import kotlinx.coroutines.flow.Flow
import ru.coolhabit.currencyconverter.core.api.IDatabaseStorage
import ru.coolhabit.currencyconverter.entities.dto.Currency

class DatabaseStorageImpl (context: Context) : IDatabaseStorage {

    override suspend fun addCurrencyToFav(currency: Currency) {
        TODO("Not yet implemented")
    }

    override suspend fun removeCurrencyFromFav(currency: Currency) {
        TODO("Not yet implemented")
    }

    override fun getFavouriteCurrency(): Flow<List<Currency>> {
        TODO("Not yet implemented")
    }
}
