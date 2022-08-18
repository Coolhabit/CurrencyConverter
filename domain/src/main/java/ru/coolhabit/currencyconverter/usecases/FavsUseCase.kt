package ru.coolhabit.currencyconverter.usecases

import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.core.api.IDatabaseStorage
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.extensions.toSymbols
import javax.inject.Inject

class FavsUseCase @Inject constructor(
    private val service: ICurrencyApiService,
    private val database: IDatabaseStorage,
) {

    suspend fun loadFavRatesList(base: String?): List<Currency> {
        val favouritesList = database.getFavouritesList().toSymbols()
        return service.getFavouriteRates(base, favouritesList)
    }

    suspend fun removeCurrencyFromFav(currency: Currency) {
        database.removeCurrencyFromFav(currency)
    }

    suspend fun loadCurrencies(): List<String> {
        return service.getCurrencies()
    }
}
