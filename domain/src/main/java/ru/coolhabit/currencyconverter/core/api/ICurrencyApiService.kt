package ru.coolhabit.currencyconverter.core.api

import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.entities.dto.Symbol

interface ICurrencyApiService {

    suspend fun getLatestRates(): List<Currency>

    suspend fun getSymbols(): List<Symbol>
}
