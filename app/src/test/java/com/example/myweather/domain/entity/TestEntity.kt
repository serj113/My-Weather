package com.example.myweather.domain.entity

val main = Main(
    1.0,
    2.0,
    3.0,
    4.0,
    5,
    6,
    7,
    8,
    9.0
)
val weather = Weather(1, "main", "description", "icon")
val listWeather = ListWeather(
    1,
    main,
    listOf(weather),
    "dt_txt"
)
val forecast = Forecast(listOf(listWeather))