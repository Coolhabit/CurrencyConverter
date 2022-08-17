package ru.coolhabit.currencyconverter.data.network.mappers

import ru.coolhabit.currencyconverter.entities.dto.Currency

fun Pair<String, Double>.toCurrency(): Currency {
    return Currency(
        currencyName = first,
        currencyRate = second,
        isFav = false,
    )
}
