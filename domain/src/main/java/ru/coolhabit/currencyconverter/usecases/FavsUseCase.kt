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

    suspend fun getFavRates(base: String?): List<Currency> {
        val favs = database.getFavouriteCurrency().toSymbols()
        println(favs)
        return service.getFavRates(base, favs)
    }

    suspend fun removeCurrencyFromFav(currency: Currency) {
        database.removeCurrencyFromFav(currency)
    }

    suspend fun getFavouritesList(): List<Currency> {
        return database.getFavouriteCurrency()
    }

    suspend fun getCurrencies(): List<String> {
        return service.getCurrencies()
    }
}
