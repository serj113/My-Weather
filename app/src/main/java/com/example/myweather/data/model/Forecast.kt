package com.example.myweather.data.model

data class Forecast(
    val cod : Int,
    val message : Int,
    val cnt : Int,
    val list : List<ListWeather>,
    val city : City
)