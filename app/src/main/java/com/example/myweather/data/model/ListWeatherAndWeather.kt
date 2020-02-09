package com.example.myweather.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class ListWeatherAndWeather(
    @Embedded
    var listWeather: ListWeatherCache,
    @Relation(
        parentColumn = "listweatherid",
        entity = WeatherCache::class,
        entityColumn = "listWeatherId"
    )
    var weather: List<WeatherCache>
)