package com.example.myweather.data.model

import com.example.myweather.domain.entity.ListWeather

data class ListWeatherRemote(
    val dt: Int,
    val main: MainRemote,
    val weather: List<WeatherRemote>,
    val clouds: CloudsRemote,
    val wind: WindRemote,
    val sys: SysRemote,
    val dt_txt: String
)

fun ListWeatherRemote.mapToDomain(): ListWeather =
    ListWeather(dt, main.mapToDomain(), weather.mapToDomain(), dt_txt)

fun List<ListWeatherRemote>.mapToDomain(): List<ListWeather> = map { it.mapToDomain() }