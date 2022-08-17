package ru.coolhabit.currencyconverter.currency.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.usecases.CurrencyUseCase
import javax.inject.Inject

class CurrencyViewModel @Inject constructor(
    private val useCase: CurrencyUseCase,
) : ViewModel() {

    private val _loadList = MutableSharedFlow<List<String>>()
    val loadList = _loadList.asSharedFlow()

    private val _loadCurrency = MutableSharedFlow<List<Currency>>()
    val loadCurrency = _loadCurrency.asSharedFlow()

    fun loadCurrencyList() {
        viewModelScope.launch {
            _loadCurrency.emit(useCase.getCurrencyList())
        }
    }

    fun loadCurrencies() {
        viewModelScope.launch {
            _loadList.emit(useCase.getCurrencies())
        }
    }

    fun addToFavourite(currency: Currency) {
        viewModelScope.launch {
            useCase.addCurrencyToFav(currency)
            loadCurrencyList()
        }
    }

    fun removeFromFavourite(currency: Currency) {
        viewModelScope.launch {
            useCase.removeCurrencyFromFav(currency)
            loadCurrencyList()
        }
    }
}
