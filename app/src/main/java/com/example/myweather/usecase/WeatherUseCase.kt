package com.example.myweather.usecase

import com.example.myweather.domain.Weather

interface WeatherUseCase {
    fun getWeathers(): List<Weather>
}