package ru.coolhabit.currencyconverter.usecases

import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.entities.dto.Currency
import javax.inject.Inject

class CurrencyUseCase @Inject constructor(
    private val service: ICurrencyApiService,
) {

    suspend fun getCurrencyList(): List<Currency> {
        return service.getLatestRates()
    }
}
