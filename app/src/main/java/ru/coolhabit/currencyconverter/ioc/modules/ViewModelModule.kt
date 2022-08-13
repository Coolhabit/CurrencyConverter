package ru.coolhabit.currencyconverter.ioc.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.coolhabit.currencyconverter.currency.presentation.CurrencyViewModel
import ru.coolhabit.currencyconverter.favs.presentation.FavsViewModel
import ru.coolhabit.currencyconverter.ioc.utils.ViewModelFactory
import ru.coolhabit.currencyconverter.ioc.utils.ViewModelKey
import ru.coolhabit.currencyconverter.presentation.MainActivityViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun mainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CurrencyViewModel::class)
    abstract fun currencyViewModel(viewModel: CurrencyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavsViewModel::class)
    abstract fun favsViewModel(viewModel: FavsViewModel): ViewModel
}
