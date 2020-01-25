package com.example.myweather.data.datasource.remote

import com.example.myweather.data.api.WeatherApi
import com.example.myweather.data.model.ForecastRemote
import com.example.myweather.data.source.WeatherRemoteSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherRemoteSourceImpl
@Inject
constructor(private val weatherApi: WeatherApi) : WeatherRemoteSource {
    override fun getWeathers(city: String): Single<ForecastRemote> {
        return weatherApi.getForecast(city)
            .subscribeOn(Schedulers.io())
            .map { it.weather }
    }
}