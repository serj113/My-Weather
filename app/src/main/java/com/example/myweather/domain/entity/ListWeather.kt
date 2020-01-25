package com.example.myweather.domain.entity

data class ListWeather(
    val dt : Int,
    val main : Main,
    val weather : List<Weather>,
    val dt_txt : String
)