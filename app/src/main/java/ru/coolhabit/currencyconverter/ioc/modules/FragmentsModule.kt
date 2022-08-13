package ru.coolhabit.currencyconverter.ioc.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(includes = [ViewModelModule::class, ActivityModule::class])
abstract class FragmentsModule {

//    @ContributesAndroidInjector
//    abstract fun provideHeroesFragment(): HeroesFragment
//
//    @ContributesAndroidInjector
//    abstract fun provideComicsFragment(): ComicsFragment
//
//    @ContributesAndroidInjector
//    abstract fun provideMyAvengersFragment(): MyAvengersFragment
//
//    @ContributesAndroidInjector
//    abstract fun provideSettingsFragment(): SettingsFragment
}
