package ru.coolhabit.currencyconverter.data.network

import retrofit2.http.GET
import ru.coolhabit.currencyconverter.data.network.entities.currency.CurrencyResponse

interface CurrencyApi {
    @GET("latest")
    suspend fun getLatest(): CurrencyResponse
}
