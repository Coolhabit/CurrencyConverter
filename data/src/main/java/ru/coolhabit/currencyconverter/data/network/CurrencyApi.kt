package ru.coolhabit.currencyconverter.data.network

import retrofit2.http.GET
import ru.coolhabit.currencyconverter.data.network.entities.currency.CurrencyResponse
import ru.coolhabit.currencyconverter.data.network.entities.currency.SymbolsResponse

interface CurrencyApi {
    @GET("latest")
    suspend fun getLatest(): CurrencyResponse

    @GET("symbols")
    suspend fun getSymbols(): SymbolsResponse
}
