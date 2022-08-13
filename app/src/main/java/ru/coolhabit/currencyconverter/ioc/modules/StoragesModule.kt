package ru.coolhabit.currencyconverter.ioc.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.coolhabit.currencyconverter.core.api.IDatabaseStorage
import ru.coolhabit.currencyconverter.data.db.DatabaseStorageImpl
import javax.inject.Singleton

@Module
class StoragesModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): IDatabaseStorage = DatabaseStorageImpl(context)
}
