package com.example.myweather.data.model

import androidx.room.Entity
import com.example.myweather.domain.entity.Weather

@Entity
data class WeatherRemote (
    val id : Int,
    val main : String,
    val description : String,
    val icon : String
)

fun WeatherRemote.mapToDomain(): Weather = Weather(id, main, description, icon)

fun List<WeatherRemote>.mapToDomain(): List<Weather> = map { it.mapToDomain() }