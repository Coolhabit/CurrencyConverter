package ru.coolhabit.currencyconverter.extensions

import ru.coolhabit.currencyconverter.entities.dto.Currency

fun List<Currency>.toSymbols(): String {
    return this.joinToString(",") {it.currencyName}
}
