package ru.coolhabit.currencyconverter.core.api

import kotlinx.coroutines.flow.Flow
import ru.coolhabit.currencyconverter.entities.dto.Currency

interface IDatabaseStorage {

    suspend fun addCurrencyToFav(currency: Currency)

    suspend fun removeCurrencyFromFav(currency: Currency)

    fun getFavouriteCurrency(): Flow<List<Currency>>
}
