package com.example.myweather.data.model

import androidx.room.Embedded
import androidx.room.Entity
import com.example.myweather.domain.entity.ListWeather

@Entity
data class ListWeatherRemote(
    val dt: Int,
    @Embedded
    val main: MainRemote,
    val weather: List<WeatherRemote>,
    @Embedded
    val clouds: CloudsRemote,
    @Embedded
    val wind: WindRemote,
    @Embedded
    val sys: SysRemote,
    val dt_txt: String
)

fun ListWeatherRemote.mapToDomain(): ListWeather =
    ListWeather(dt, main.mapToDomain(), weather.mapToDomain(), dt_txt)

fun List<ListWeatherRemote>.mapToDomain(): List<ListWeather> = map { it.mapToDomain() }