package com.example.myweather.data.source

import com.example.myweather.data.model.Forecast

interface WeatherCacheSource {
    fun getWeathers(): List<Forecast>
}

interface WeatherRemoteSource {
    fun getWeathers(): List<Forecast>
}