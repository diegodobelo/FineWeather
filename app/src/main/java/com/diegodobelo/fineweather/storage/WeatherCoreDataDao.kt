package com.diegodobelo.fineweather.storage

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.diegodobelo.fineweather.models.WeatherCoreData

@Dao
interface WeatherCoreDataDao {
    @Query("SELECT * FROM weather_core_data")
    fun getAll(): List<WeatherCoreData>
}