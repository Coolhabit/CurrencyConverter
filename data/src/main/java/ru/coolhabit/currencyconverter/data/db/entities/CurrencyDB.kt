package ru.coolhabit.currencyconverter.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import ru.coolhabit.currencyconverter.data.db.AppDatabase.Companion.DATABASE_NAME
import ru.coolhabit.currencyconverter.entities.dto.Currency

@Entity(tableName = DATABASE_NAME)
data class CurrencyDB(
    @ColumnInfo(name = "dbCurrencyName") val dbCurrencyName: String,
    @ColumnInfo(name = "dbCurrencyRate") val dbCurrencyRate: Double,
)

fun Currency.toData() = CurrencyDB(
    dbCurrencyName = currencyName,
    dbCurrencyRate = currencyRate,
)

fun CurrencyDB.toDomain() = Currency(
    currencyName = dbCurrencyName,
    currencyRate = dbCurrencyRate,
)
