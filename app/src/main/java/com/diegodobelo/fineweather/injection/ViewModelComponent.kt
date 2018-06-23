package com.diegodobelo.fineweather.injection

import com.diegodobelo.fineweather.MainViewModel
import dagger.Component

@Component( modules = arrayOf(ViewModelModule::class))
interface ViewModelComponent {
    fun inject( mainViewModel: MainViewModel )
}