package ru.coolhabit.currencyconverter.favs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.coolhabit.currencyconverter.entities.dto.Currency
import ru.coolhabit.currencyconverter.usecases.FavsUseCase
import javax.inject.Inject

class FavsViewModel @Inject constructor(
    private val useCase: FavsUseCase,
) : ViewModel() {

    private val _loadList = MutableSharedFlow<List<Currency>>()
    val loadList: Flow<List<Currency>>
        get() = _loadList

    fun loadFavList() {
        viewModelScope.launch {
            _loadList.emit(useCase.getFavouritesList())
        }
    }

    fun removeFromFavourite(currency: Currency) {
        viewModelScope.launch {
            useCase.removeCurrencyFromFav(currency)
            loadFavList()
        }
    }
}
