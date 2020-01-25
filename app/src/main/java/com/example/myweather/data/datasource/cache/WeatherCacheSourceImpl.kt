package com.example.myweather.data.datasource.cache

import com.example.myweather.data.model.ForecastRemote
import com.example.myweather.data.source.WeatherCacheSource

class WeatherCacheSourceImpl : WeatherCacheSource {
    override fun getWeathers(city: String): List<ForecastRemote> {
        return listOf()
    }
}