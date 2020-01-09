package com.example.myweather.data.repository

import com.example.myweather.data.source.WeatherCacheSource
import com.example.myweather.data.source.WeatherRemoteSource
import com.example.myweather.domain.entity.Weather
import com.example.myweather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl
@Inject
constructor(
    private val weatherCacheSource: WeatherCacheSource,
    private val weatherRemoteSource: WeatherRemoteSource
) : WeatherRepository {
    override fun getWeathers(): List<Weather> {
        return listOf()
    }
}