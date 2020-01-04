package com.example.myweather.domain.repository

import com.example.myweather.domain.entity.Weather

interface WeatherRepository {
    fun getWeathers(): List<Weather>
}