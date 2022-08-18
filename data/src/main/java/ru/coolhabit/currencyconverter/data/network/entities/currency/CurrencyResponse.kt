package ru.coolhabit.currencyconverter.data.network.entities.currency

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("rates")
    val rates: Map<String, Double>,
    @SerializedName("success")
    val success: Boolean,
)
