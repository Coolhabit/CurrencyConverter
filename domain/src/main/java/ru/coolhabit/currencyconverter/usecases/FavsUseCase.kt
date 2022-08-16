package ru.coolhabit.currencyconverter.usecases

import ru.coolhabit.currencyconverter.core.api.IDatabaseStorage
import ru.coolhabit.currencyconverter.entities.dto.Currency
import javax.inject.Inject

class FavsUseCase @Inject constructor(
    private val database: IDatabaseStorage,
) {

    suspend fun addCurrencyToFav(currency: Currency) {
        database.addCurrencyToFav(currency)
    }

    suspend fun removeCurrencyFromFav(currency: Currency) {
        database.removeCurrencyFromFav(currency)
    }

    suspend fun getFavouritesList(): List<Currency> {
        return database.getFavouriteCurrency()
    }
}
