package com.example.myweather.data.model

import com.example.myweather.domain.entity.Forecast
import java.util.*

data class ForecastRemote(
    var id: String = UUID.randomUUID().toString(),
    var cod : Int = 0,
    var message : Int = 0,
    var cnt : Int = 0,
    var list : List<ListWeatherRemote> = listOf()
)

fun ForecastRemote.mapToDomain(): Forecast = Forecast(list.mapToDomain())