package com.diegodobelo.fineweather.network

import com.diegodobelo.fineweather.models.WeatherData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DarkSkyService {

    @GET("{lat},{lng}")
    fun getForecast(@Path("lat") lat: String,
                    @Path("lng") lng: String): Single<WeatherData>
}