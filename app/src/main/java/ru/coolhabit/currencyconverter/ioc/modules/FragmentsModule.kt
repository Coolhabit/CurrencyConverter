package ru.coolhabit.currencyconverter.ioc.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.coolhabit.currencyconverter.currency.presentation.CurrencyFragment
import ru.coolhabit.currencyconverter.favs.presentation.FavsFragment


@Module(includes = [ViewModelModule::class, ActivityModule::class])
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun provideCurrencyFragment(): CurrencyFragment

    @ContributesAndroidInjector
    abstract fun provideFavsFragment(): FavsFragment
}
