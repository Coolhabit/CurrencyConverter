package ru.coolhabit.currencyconverter.usecases

import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.core.api.IDatabaseStorage
import ru.coolhabit.currencyconverter.entities.dto.Currency
import javax.inject.Inject

class CurrencyUseCase @Inject constructor(
    private val service: ICurrencyApiService,
    private val database: IDatabaseStorage,
) {

    suspend fun getCurrencyList(): List<Currency> {
        val favList = getFavouritesList()
        val currentList = service.getLatestRates()
        currentList.find { it in favList }?.isFav = true

        return currentList
    }

    suspend fun addCurrencyToFav(currency: Currency) {
        database.addCurrencyToFav(currency)
    }

    suspend fun removeCurrencyFromFav(currency: Currency) {
        database.removeCurrencyFromFav(currency)
    }

    private suspend fun getFavouritesList(): List<Currency> {
        return database.getFavouriteCurrency()
    }
}