package ru.coolhabit.currencyconverter.core.api

import ru.coolhabit.currencyconverter.entities.dto.Currency

interface IDatabaseStorage {

    suspend fun addCurrencyToFav(currency: Currency)

    suspend fun removeCurrencyFromFav(currency: Currency)

    suspend fun getFavouriteCurrency(): List<Currency>
}
