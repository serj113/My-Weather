package com.example.myweather.data.repository

import com.example.myweather.data.model.ForecastRemote
import com.example.myweather.data.model.mapToDomain
import com.example.myweather.data.source.WeatherCacheSource
import com.example.myweather.data.source.WeatherRemoteSource
import com.example.myweather.domain.entity.Forecast
import com.example.myweather.domain.repository.WeatherRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherRepositoryImpl
@Inject
constructor(
    private val weatherCacheSource: WeatherCacheSource,
    private val weatherRemoteSource: WeatherRemoteSource
) : WeatherRepository {
    override fun getWeathers(city: String): Single<Forecast> {
        return weatherRemoteSource.getWeathers(city)
            .subscribeOn(Schedulers.io())
            .map { it.mapToDomain() }
    }
}