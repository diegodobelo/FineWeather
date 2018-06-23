package com.diegodobelo.fineweather.injection

import android.content.Context

import com.diegodobelo.fineweather.FineWeatherApplication

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    internal fun provideContext(application: FineWeatherApplication): Context {
        return application.applicationContext
    }
}
