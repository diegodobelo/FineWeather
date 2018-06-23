package com.diegodobelo.fineweather.injection

import com.diegodobelo.fineweather.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
