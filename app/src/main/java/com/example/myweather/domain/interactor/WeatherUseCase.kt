package com.example.myweather.domain.interactor

import com.example.myweather.domain.entity.Forecast
import io.reactivex.Single

interface WeatherUseCase {
    fun getWeathers(city: String): Single<Forecast>
}