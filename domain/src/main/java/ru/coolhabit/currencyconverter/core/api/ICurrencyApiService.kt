package ru.coolhabit.currencyconverter.core.api

import ru.coolhabit.currencyconverter.entities.dto.Currency

interface ICurrencyApiService {

    suspend fun getLatestRates(base: String?): List<Currency>

    suspend fun getFavouriteRates(base: String?, symbols: String?): List<Currency>

    suspend fun getCurrencies(): List<String>
}
