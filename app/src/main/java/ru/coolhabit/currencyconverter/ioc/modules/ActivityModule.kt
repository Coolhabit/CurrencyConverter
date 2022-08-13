package ru.coolhabit.currencyconverter.ioc.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.coolhabit.currencyconverter.presentation.MainActivity

@Module(includes = [ViewModelModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun mainActivity(): MainActivity
}