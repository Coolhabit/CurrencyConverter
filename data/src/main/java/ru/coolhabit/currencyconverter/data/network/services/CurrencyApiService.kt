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

    override suspend fun getBaseRates(base: String?): List<Currency> {
        val result = api.getLatest(base = base).rates.toList().map {
            it.toCurrency()
        }
        return result
    }

    override suspend fun getFavRates(base: String?, symbols: String?): List<Currency> {
        val result = api.getLatest(base = base, symbols = symbols).rates.toList().map {
            it.toCurrency()
        }
        return result
    }


    override suspend fun getCurrencies(): List<String> {
        val result = api.getLatest().rates.toList().map {
            it.first
        }
        return result
    }
}
