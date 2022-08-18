package ru.coolhabit.currencyconverter.usecases

import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.core.api.IDatabaseStorage
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.entities.dto.CurrencyData
import ru.coolhabit.currencyconverter.entities.dto.SortType
import ru.coolhabit.currencyconverter.extensions.toSymbols
import javax.inject.Inject

class FavsUseCase @Inject constructor(
    private val service: ICurrencyApiService,
    private val database: IDatabaseStorage,
) {

    suspend fun loadFavCurrencyData(base: String?, sortType: SortType?): CurrencyData {
        return CurrencyData(
            list = loadFavRatesList(base, sortType),
            currencies = service.getCurrencies()
        )
    }

    private suspend fun loadFavRatesList(base: String?, sortType: SortType?): List<Currency> {
        val favouritesList = database.getFavouritesList().toSymbols()
        val resultList = service.getFavouriteRates(base, favouritesList)
        return when(sortType) {
            SortType.ALP_ASC -> resultList.sortedBy { it.currencyName }
            SortType.ALP_DESC -> resultList.sortedByDescending { it.currencyName }
            SortType.VALUE_ASC -> resultList.sortedBy { it.currencyRate }
            SortType.VALUE_DESC -> resultList.sortedByDescending { it.currencyRate }
            null -> resultList
        }
    }

    suspend fun removeCurrencyFromFav(currency: Currency) {
        database.removeCurrencyFromFav(currency)
    }
}
