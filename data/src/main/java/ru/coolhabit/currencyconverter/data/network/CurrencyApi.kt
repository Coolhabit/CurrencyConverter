package ru.coolhabit.currencyconverter.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.coolhabit.currencyconverter.data.network.entities.currency.CurrencyResponse

interface CurrencyApi {

    @GET("latest")
    suspend fun getLatest(
        @Query("base") base: String? = null
    ): CurrencyResponse
}
