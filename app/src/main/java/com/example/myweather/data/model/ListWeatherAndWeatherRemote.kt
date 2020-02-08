package com.example.myweather.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class ListWeatherAndWeatherRemote(
    @Embedded
    var listWeather: ListWeatherCache,
    @Relation()
    val weather: List<WeatherCache>
)