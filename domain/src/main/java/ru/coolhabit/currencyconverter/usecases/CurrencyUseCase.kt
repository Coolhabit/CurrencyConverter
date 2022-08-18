package ru.coolhabit.currencyconverter.usecases

import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.core.api.IDatabaseStorage
import ru.coolhabit.currencyconverter.entities.dto.Currency
import javax.inject.Inject

class CurrencyUseCase @Inject constructor(
    private val service: ICurrencyApiService,
    private val database: IDatabaseStorage,
) {

    suspend fun loadRatesList(base: String?): List<Currency> {
        val favList = database.getFavouritesList()
        val currentList = service.getLatestRates(base)
        currentList.map {
            it.isFav = favList.any { fav -> fav.currencyName == it.currencyName }
        }
        return currentList
    }

    suspend fun addCurrencyToFav(currency: Currency) {
        database.addCurrencyToFav(currency)
    }

    suspend fun removeCurrencyFromFav(currency: Currency) {
        database.removeCurrencyFromFav(currency)
    }

    suspend fun loadCurrencies(): List<String> {
        return service.getCurrencies()
    }
}
