package ru.coolhabit.currencyconverter.data.network.entities.currency

import com.google.gson.annotations.SerializedName

data class SymbolsResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("symbols")
    val symbols: Map<String, String>
)
