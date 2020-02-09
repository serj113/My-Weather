package com.example.myweather.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class ForecastAndListWeather(
    @Embedded
    var forecast: ForecastCache,
    @Relation(
        parentColumn = "forecastid",
        entity = ListWeatherCache::class,
        entityColumn = "forecastId"
    )
    var listWeather: List<ListWeatherCache>
)