package ru.coolhabit.currencyconverter.core.api

import ru.coolhabit.currencyconverter.entities.dto.Currency

interface ICurrencyApiService {

    suspend fun getLatestRates(): List<Currency>

    suspend fun getBaseRates(base: String?): List<Currency>

    suspend fun getCurrencies(): List<String>
}
