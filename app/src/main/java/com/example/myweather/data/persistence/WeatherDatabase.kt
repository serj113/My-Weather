package com.example.myweather.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myweather.data.dao.WeatherDao
import com.example.myweather.data.model.ForecastRemote

@Database(entities = [ForecastRemote::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}