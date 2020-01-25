package com.example.myweather.data.model

val windRemote = WindRemote(1.0, 1)
val sysRemote = SysRemote("pod")
val cloudsRemote = CloudsRemote(1)
val coordRemote = CoordRemote(1.0, 2.0)
val cityRemote = CityRemote(
    1,
    "name",
    coordRemote,
    "country",
    2,
    3,
    4,
    5
)
val weatherRemote = WeatherRemote(1, "main", "description", "icon")
val mainRemote = MainRemote(
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
val listWeatherRemote = ListWeatherRemote(
    1,
    mainRemote,
    listOf(weatherRemote),
    cloudsRemote,
    windRemote,
    sysRemote,
    "dt_txt"
)
val forecastRemote = ForecastRemote(
    1,
    2,
    3,
    listOf(listWeatherRemote),
    cityRemote
)
val response = Response(forecastRemote)