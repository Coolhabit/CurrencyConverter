package ru.coolhabit.currencyconverter.currency.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.entities.dto.CurrencyData
import ru.coolhabit.currencyconverter.entities.dto.SortType
import ru.coolhabit.currencyconverter.usecases.CurrencyUseCase
import javax.inject.Inject

class CurrencyViewModel @Inject constructor(
    private val useCase: CurrencyUseCase,
) : ViewModel() {

    var sortType: SortType? = null
    var baseCurrency: String? = null

    private val _loadData = MutableSharedFlow<CurrencyData>()
    val loadData = _loadData.asSharedFlow()

    fun initLoad() {
        viewModelScope.launch {
            _loadData.emit(useCase.loadCurrencyData(baseCurrency, sortType))
        }
    }

    fun addToFavourite(currency: Currency) {
        viewModelScope.launch {
            useCase.addCurrencyToFav(currency)
            initLoad()
        }
    }

    fun removeFromFavourite(currency: Currency) {
        viewModelScope.launch {
            useCase.removeCurrencyFromFav(currency)
            initLoad()
        }
    }
}
