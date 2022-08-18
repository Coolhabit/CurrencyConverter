package ru.coolhabit.currencyconverter.ioc.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.coolhabit.currencyconverter.ConcurrencyApp

@Module
class ApplicationModule {

    @Provides
    fun provideContext(app: ConcurrencyApp): Context = app.applicationContext
}
