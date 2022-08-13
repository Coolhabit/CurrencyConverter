package ru.coolhabit.currencyconverter.ioc.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
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

//    @Binds
//    @IntoMap
//    @ViewModelKey(HeroesViewModel::class)
//    abstract fun heroesViewModel(viewModel: HeroesViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(ComicsViewModel::class)
//    abstract fun comicsViewModel(viewModel: ComicsViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(MyAvengersViewModel::class)
//    abstract fun myAvengersViewModel(viewModel: MyAvengersViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(SettingsViewModel::class)
//    abstract fun settingsViewModel(viewModel: SettingsViewModel): ViewModel
}
