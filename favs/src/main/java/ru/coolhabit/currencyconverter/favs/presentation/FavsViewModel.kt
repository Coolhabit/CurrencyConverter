package ru.coolhabit.currencyconverter.favs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.entities.dto.SortType
import ru.coolhabit.currencyconverter.usecases.FavsUseCase
import javax.inject.Inject

class FavsViewModel @Inject constructor(
    private val useCase: FavsUseCase,
) : ViewModel() {

    var sortType: SortType? = null
    var baseCurrency: String? = null

    private val _loadList = MutableSharedFlow<List<Currency>>()
    val loadList: Flow<List<Currency>>
        get() = _loadList

    private val _currencies = MutableSharedFlow<List<String>>()
    val currencies = _currencies.asSharedFlow()

    fun loadFavRatesList() {
        viewModelScope.launch {
            _loadList.emit(useCase.loadFavRatesList(baseCurrency, sortType))
        }
    }

    fun loadCurrencies() {
        viewModelScope.launch {
            _currencies.emit(useCase.loadCurrencies())
        }
    }

    fun removeFromFavourite(currency: Currency) {
        viewModelScope.launch {
            useCase.removeCurrencyFromFav(currency)
            loadFavRatesList()
        }
    }
}
