package ru.coolhabit.currencyconverter.ioc.modules

import dagger.Module
import dagger.Provides
import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.data.network.CurrencyApi
import ru.coolhabit.currencyconverter.data.network.services.CurrencyApiService
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideCurrencyApiService(api: CurrencyApi): ICurrencyApiService = CurrencyApiService(api)
}
