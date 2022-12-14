package ru.coolhabit.currencyconverter

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.coolhabit.currencyconverter.ioc.DaggerApplicationComponent

class ConcurrencyApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
            .factory()
            .create(this)
    }
}