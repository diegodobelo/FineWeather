package com.diegodobelo.fineweather.storage

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.diegodobelo.fineweather.models.WeatherCoreData
import com.diegodobelo.fineweather.models.WeatherData

@Database(entities = arrayOf(WeatherCoreData::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDataCoreDao(): WeatherCoreDataDao
}