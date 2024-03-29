package com.example.myweather.data.source

import com.example.myweather.data.model.ForecastCache
import com.example.myweather.data.model.ForecastRemote
import io.reactivex.Single

interface WeatherCacheSource {
    fun getWeathers(city: String): Single<ForecastCache>
}

interface WeatherRemoteSource {
    fun getWeathers(city: String): Single<ForecastRemote>
}