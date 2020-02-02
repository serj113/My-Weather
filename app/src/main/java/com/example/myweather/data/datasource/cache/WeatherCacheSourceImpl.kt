package com.example.myweather.data.datasource.cache

import com.example.myweather.data.dao.WeatherDao
import com.example.myweather.data.model.ForecastRemote
import com.example.myweather.data.source.WeatherCacheSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherCacheSourceImpl
@Inject
constructor(private val weatherDao: WeatherDao) : WeatherCacheSource {
    override fun getWeathers(city: String): Single<ForecastRemote> {
        return weatherDao.getForecastById(city)
            .subscribeOn(Schedulers.io())
    }
}