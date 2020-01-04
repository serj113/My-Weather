package com.example.myweather.data.datasource.remote

import com.example.myweather.data.model.WeatherModel
import com.example.myweather.data.source.WeatherRemoteSource

class WeatherRemoteSourceImpl : WeatherRemoteSource {
    override fun getWeathers(): List<WeatherModel> {
        return listOf()
    }
}