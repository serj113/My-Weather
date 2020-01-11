package com.example.myweather.data.datasource.cache

import com.example.myweather.data.model.Forecast
import com.example.myweather.data.source.WeatherCacheSource

class WeatherCacheSourceImpl : WeatherCacheSource {
    override fun getWeathers(): List<Forecast> {
        return listOf()
    }
}