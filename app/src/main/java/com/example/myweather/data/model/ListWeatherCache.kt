package com.example.myweather.data.model

import androidx.room.Embedded
import androidx.room.Entity
import com.example.myweather.domain.entity.ListWeather

@Entity
data class ListWeatherCache(
    val dt: Int,
    @Embedded
    val main: MainRemote,
    @Embedded
    val clouds: CloudsRemote,
    @Embedded
    val wind: WindRemote,
    @Embedded
    val sys: SysRemote,
    val dt_txt: String
)