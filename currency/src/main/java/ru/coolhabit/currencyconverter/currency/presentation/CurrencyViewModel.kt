package ru.coolhabit.currencyconverter.currency.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.entities.dto.SortType
import ru.coolhabit.currencyconverter.usecases.CurrencyUseCase
import javax.inject.Inject

class CurrencyViewModel @Inject constructor(
    private val useCase: CurrencyUseCase,
) : ViewModel() {

    var sortType: SortType? = null
    var baseCurrency: String? = null

    private val _loadList = MutableSharedFlow<List<Currency>>()
    val loadList = _loadList.asSharedFlow()

    private val _currencies = MutableSharedFlow<List<String>>()
    val currencies = _currencies.asSharedFlow()

    fun loadRatesList() {
        viewModelScope.launch {
            _loadList.emit(useCase.loadRatesList(baseCurrency, sortType))
        }
    }

    fun loadCurrencies() {
        viewModelScope.launch {
            _currencies.emit(useCase.loadCurrencies())
        }
    }

    fun addToFavourite(currency: Currency) {
        viewModelScope.launch {
            useCase.addCurrencyToFav(currency)
            loadRatesList()
        }
    }

    fun removeFromFavourite(currency: Currency) {
        viewModelScope.launch {
            useCase.removeCurrencyFromFav(currency)
            loadRatesList()
        }
    }
}
