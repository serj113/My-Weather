package com.example.myweather.repository

import com.example.myweather.domain.Weather

class WeatherRepositoryImpl: WeatherRepository {
    override fun getWeathers(): List<Weather> {
        return listOf()
    }
}