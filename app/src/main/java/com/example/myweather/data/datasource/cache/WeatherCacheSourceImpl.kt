package com.example.myweather.data.datasource.cache

import com.example.myweather.data.model.WeatherModel
import com.example.myweather.data.source.WeatherCacheSource

class WeatherCacheSourceImpl : WeatherCacheSource {
    override fun getWeathers(): List<WeatherModel> {
        return listOf()
    }
}