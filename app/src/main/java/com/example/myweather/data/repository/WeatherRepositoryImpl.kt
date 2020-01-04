package com.example.myweather.data.repository

import com.example.myweather.domain.entity.Weather
import com.example.myweather.domain.repository.WeatherRepository

class WeatherRepositoryImpl: WeatherRepository {
    override fun getWeathers(): List<Weather> {
        return listOf()
    }
}