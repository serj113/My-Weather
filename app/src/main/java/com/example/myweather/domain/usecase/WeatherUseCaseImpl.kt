package com.example.myweather.domain.usecase

import com.example.myweather.domain.entity.Forecast
import com.example.myweather.domain.interactor.WeatherUseCase
import com.example.myweather.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherUseCaseImpl
@Inject
constructor(
    private val weatherRepository: WeatherRepository
) : WeatherUseCase {
    override fun getWeathers(city: String): Single<Forecast> {
        return weatherRepository.getWeathers(city)
    }
}