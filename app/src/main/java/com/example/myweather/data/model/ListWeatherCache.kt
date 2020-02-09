package com.example.myweather.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myweather.domain.entity.ListWeather

@Entity
data class ListWeatherCache(
    @PrimaryKey
    var id : Int,
    var dt: Int,
    var forecastId: Int,
    @Embedded
    var main: MainRemote,
    @Embedded
    var clouds: CloudsRemote,
    @Embedded
    var wind: WindRemote,
    @Embedded
    var sys: SysRemote,
    var dt_txt: String
)