package com.example.myweather.data.model

import com.example.myweather.domain.entity.Forecast

data class ForecastRemote(
    val cod : Int,
    val message : Int,
    val cnt : Int,
    val list : List<ListWeatherRemote>,
    val city : CityRemote
)

fun ForecastRemote.mapToDomain(): Forecast = Forecast(list.mapToDomain())