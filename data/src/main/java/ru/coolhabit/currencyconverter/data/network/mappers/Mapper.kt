package ru.coolhabit.currencyconverter.data.network.mappers

import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.entities.dto.Symbol

fun Pair<String, Double>.toCurrency(): Currency {
    return Currency(
        currencyName = first,
        currencyRate = second,
        isFav = false,
    )
}

fun Pair<String, String>.toSymbol(): Symbol {
    return Symbol(
        symbolAbb = first,
        symbolName = second,
    )
}
