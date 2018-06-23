package com.diegodobelo.fineweather.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.diegodobelo.fineweather.MainViewModel
import dagger.Module
import dagger.Binds
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey( MainViewModel::class )
    abstract fun bindMainViewModel( mainViewModel: MainViewModel ): ViewModel

    @Binds
    abstract fun bindViewModelFactory( factory: ViewModelFactory):
            ViewModelProvider.Factory

}