package ru.coolhabit.currencyconverter.ioc

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.coolhabit.currencyconverter.ConcurrencyApp
import ru.coolhabit.currencyconverter.data.ioc.RemoteModule
import ru.coolhabit.currencyconverter.ioc.modules.ActivityModule
import ru.coolhabit.currencyconverter.ioc.modules.ApiModule
import ru.coolhabit.currencyconverter.ioc.modules.ApplicationModule
import ru.coolhabit.currencyconverter.ioc.modules.FragmentsModule
import ru.coolhabit.currencyconverter.ioc.modules.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        ApplicationModule::class,
        FragmentsModule::class,
//        UseCasesModule::class,
//        NavigationRoutersModule::class,
        ApiModule::class,
        RemoteModule::class,
//        StoragesModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<ConcurrencyApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: ConcurrencyApp): ApplicationComponent
    }
}
