package com.example.myweather.domain.repository

import com.example.myweather.domain.entity.Forecast
import io.reactivex.Single

interface WeatherRepository {
    fun getWeathers(city: String): Single<Forecast>
}