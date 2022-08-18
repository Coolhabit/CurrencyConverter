package ru.coolhabit.currencyconverter.entities.dto

data class Currency(
    val currencyName: String,
    val currencyRate: Double,
    var isFav: Boolean,
)
