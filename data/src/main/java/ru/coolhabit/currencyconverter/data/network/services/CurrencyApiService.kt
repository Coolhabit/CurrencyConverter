package ru.coolhabit.currencyconverter.data.network.services

import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.data.network.CurrencyApi
import ru.coolhabit.currencyconverter.entities.dto.Currency

class CurrencyApiService(private val api: CurrencyApi) : ICurrencyApiService {

    override suspend fun getLatestRates(): List<Currency> {
        val result = api.getLatest().rates.toList().map {
            Currency(
                currencyName = it.first,
                currencyRate = it.second.toDouble()
            )
        }
        return result
    }
}
