package ru.coolhabit.currencyconverter.data.network.services

import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.data.network.CurrencyApi
import ru.coolhabit.currencyconverter.data.network.mappers.toCurrency
import ru.coolhabit.currencyconverter.entities.dto.Currency

class CurrencyApiService(private val api: CurrencyApi) : ICurrencyApiService {

    override suspend fun getLatestRates(): List<Currency> {
        val result = api.getLatest().rates.toList().map {
            it.toCurrency()
        }
        return result
    }
}
