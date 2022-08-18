package ru.coolhabit.currencyconverter.data.network.entities.currency

import com.google.gson.annotations.SerializedName

private const val BASE = "base"
private const val RATES = "rates"
private const val SUCCESS = "success"

data class CurrencyResponse(
    @SerializedName(BASE)
    val base: String,
    @SerializedName(RATES)
    val rates: Map<String, Double>,
    @SerializedName(SUCCESS)
    val success: Boolean,
)
