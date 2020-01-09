package com.example.myweather.domain.usecase

import com.example.myweather.domain.entity.Weather
import com.example.myweather.domain.interactor.WeatherUseCase
import com.example.myweather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCaseImpl
@Inject
constructor(
    private val weatherRepository: WeatherRepository
) : WeatherUseCase {
    override fun getWeathers(): List<Weather> {
        return weatherRepository.getWeathers()
    }
}