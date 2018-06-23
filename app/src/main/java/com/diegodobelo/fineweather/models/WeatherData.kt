package com.diegodobelo.fineweather.models

data class WeatherData(
        var latitude: Float,
        var longitude: Float,
        var timezone: String,
        var currently: WeatherCoreData)