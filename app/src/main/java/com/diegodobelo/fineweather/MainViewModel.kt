package com.diegodobelo.fineweather

import android.arch.lifecycle.ViewModel
import com.diegodobelo.fineweather.models.WeatherData
import com.diegodobelo.fineweather.network.DarkSkyService
import com.diegodobelo.fineweather.storage.AppDatabase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel
@Inject constructor(private val service: DarkSkyService, private val database: AppDatabase): ViewModel() {

    fun fetchWeatherData(lat: String, lng: String): Single<WeatherData> {
        return service.getForecast(lat, lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
