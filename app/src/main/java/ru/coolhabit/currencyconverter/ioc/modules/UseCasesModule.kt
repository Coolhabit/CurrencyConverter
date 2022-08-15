package ru.coolhabit.currencyconverter.ioc.modules

import dagger.Module
import dagger.Provides
import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.usecases.CurrencyUseCase
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Provides
    @Singleton
    fun provideCurrencyUseCase(
        service: ICurrencyApiService,
    ) = CurrencyUseCase(service)
}

