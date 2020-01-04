package com.example.myweather.domain.interactor

import com.example.myweather.domain.entity.Weather

interface WeatherUseCase {
    fun getWeathers(): List<Weather>
}