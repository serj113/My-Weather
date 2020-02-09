package com.example.myweather.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myweather.data.ModelConverters
import com.example.myweather.data.dao.WeatherDao
import com.example.myweather.data.model.*

@Database(entities = [
    ForecastCache::class,
    ListWeatherCache::class,
    WeatherCache::class
], version = 1, exportSchema = false)
@TypeConverters(ModelConverters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}