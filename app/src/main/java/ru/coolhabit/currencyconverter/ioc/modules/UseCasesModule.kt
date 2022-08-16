package ru.coolhabit.currencyconverter.ioc.modules

import dagger.Module
import dagger.Provides
import ru.coolhabit.currencyconverter.core.api.ICurrencyApiService
import ru.coolhabit.currencyconverter.core.api.IDatabaseStorage
import ru.coolhabit.currencyconverter.usecases.CurrencyUseCase
import ru.coolhabit.currencyconverter.usecases.FavsUseCase
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Provides
    @Singleton
    fun provideCurrencyUseCase(
        service: ICurrencyApiService,
        database: IDatabaseStorage,
    ) = CurrencyUseCase(service, database)

    @Provides
    @Singleton
    fun provideFavsUseCase(
        database: IDatabaseStorage,
    ) = FavsUseCase(database)
}
