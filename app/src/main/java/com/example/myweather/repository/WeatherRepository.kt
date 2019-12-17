package com.example.myweather.repository

import com.example.myweather.domain.Weather

interface WeatherRepository {
    fun getWeathers(): List<Weather>
}