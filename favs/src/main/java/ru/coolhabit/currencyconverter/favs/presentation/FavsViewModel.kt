package ru.coolhabit.currencyconverter.favs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.entities.dto.CurrencyData
import ru.coolhabit.currencyconverter.entities.dto.SortType
import ru.coolhabit.currencyconverter.usecases.FavsUseCase
import javax.inject.Inject

class FavsViewModel @Inject constructor(
    private val useCase: FavsUseCase,
) : ViewModel() {

    var sortType: SortType? = null
    var baseCurrency: String? = null

    private val _loadFavData = MutableSharedFlow<CurrencyData>()
    val loadFavData = _loadFavData.asSharedFlow()

    fun initFavLoad() {
        viewModelScope.launch {
            _loadFavData.emit(useCase.loadFavCurrencyData(baseCurrency, sortType))
        }
    }

    fun removeFromFavourite(currency: Currency) {
        viewModelScope.launch {
            useCase.removeCurrencyFromFav(currency)
            initFavLoad()
        }
    }
}
