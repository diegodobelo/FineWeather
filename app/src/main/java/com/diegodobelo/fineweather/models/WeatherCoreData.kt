package com.diegodobelo.fineweather.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "weather_core_data")
data class WeatherCoreData(
        @PrimaryKey(autoGenerate = true)
        var id: Long,
        var time: Long,
        var summary: String,
        var icon: String,
        var precipIntensity: Float,
        var precipProbability: Float,
        var precipType: String,
        var temperature: Float,
        var apparentTemperature: Float,
        var dewPoint: Float,
        var humidity: Float,
        var pressure: Float,
        var windSpeed: Float,
        var windGust: Float,
        var windBearing: Float,
        var cloudCover: Float,
        var uvIndex: Int,
        var ozone: Float)