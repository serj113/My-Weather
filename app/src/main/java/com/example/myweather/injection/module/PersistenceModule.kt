package com.example.myweather.injection.module

import android.app.Application
import androidx.room.Room
import com.example.myweather.data.dao.WeatherDao
import com.example.myweather.data.persistence.WeatherDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {
    /**
     * Provides the WeatherDatabase implementation.
     * @param application the Application object used to instantiate the database
     * @return the WeatherDatabase implementation.
     */
    @Provides
    @Singleton
    internal fun provideWeatherDatabase(application: Application): WeatherDatabase {
        return Room.databaseBuilder(application,
            WeatherDatabase::class.java, "Weather.db")
            .build()
    }

    @Provides
    @Singleton
    internal fun provideWeatherDao(weatherDatabase: WeatherDatabase): WeatherDao {
        return weatherDatabase.weatherDao()
    }
}