package com.diegodobelo.fineweather.injection

import com.diegodobelo.fineweather.storage.AppDatabase
import dagger.Module
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Provides


@Module
class StorageModule {

    @Provides
    fun provideStorage(context: Context) : AppDatabase {
        return Room.databaseBuilder(context,
                AppDatabase::class.java, "weather_db").build()
    }
}