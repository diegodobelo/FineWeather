package com.diegodobelo.fineweather.injection

import com.diegodobelo.fineweather.FineWeatherApplication

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        BuildersModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        StorageModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: FineWeatherApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: FineWeatherApplication)

}
