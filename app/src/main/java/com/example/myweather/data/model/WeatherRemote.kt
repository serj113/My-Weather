package com.example.myweather.data.model

import com.example.myweather.domain.entity.Weather

data class WeatherRemote (
    val id : Int,
    val main : String,
    val description : String,
    val icon : String
)

fun WeatherRemote.mapToDomain(): Weather = Weather(id, main, description, icon)

fun List<WeatherRemote>.mapToDomain(): List<Weather> = map { it.mapToDomain() }