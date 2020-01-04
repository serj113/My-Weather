package com.example.myweather.data.source

import com.example.myweather.data.model.WeatherModel

interface WeatherCacheSource {
    fun getWeathers(): List<WeatherModel>
}

interface WeatherRemoteSource {
    fun getWeathers(): List<WeatherModel>
}