package com.example.myweather.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.myweather.data.model.ForecastCache
import io.reactivex.Single

@Dao
interface WeatherDao {

    @Query("SELECT * FROM forecast WHERE forecastid = :id")
    fun getForecastById(id: String): Single<ForecastCache>
}