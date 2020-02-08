package com.example.myweather.data.model

import androidx.room.Entity
import com.example.myweather.domain.entity.Main

@Entity
data class MainRemote(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val sea_level: Int,
    val grnd_level: Int,
    val humidity: Int,
    val temp_kf: Double
)

fun MainRemote.mapToDomain(): Main =
    Main(temp, feels_like, temp_min, temp_max, pressure, sea_level, grnd_level, humidity, temp_kf)