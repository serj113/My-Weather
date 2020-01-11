package com.example.myweather.data.datasource.remote

import com.example.myweather.data.model.Forecast
import com.example.myweather.data.source.WeatherRemoteSource

class WeatherRemoteSourceImpl : WeatherRemoteSource {
    override fun getWeathers(): List<Forecast> {
        return listOf()
    }
}