package com.example.myweather.usecase

import com.example.myweather.domain.Weather
import com.example.myweather.repository.WeatherRepository

class WeatherUseCaseImpl(private val weatherRepository: WeatherRepository): WeatherUseCase {
    override fun getWeathers(): List<Weather> {
        return weatherRepository.getWeathers()
    }
}