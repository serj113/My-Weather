package com.example.myweather.data.datasource.cache

import com.example.myweather.data.dao.WeatherDao
import com.example.myweather.data.model.forecastCache
import com.example.myweather.data.source.WeatherCacheSource
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test

class WeatherRemoteCacheSourceImplTest {
    private val weatherDao: WeatherDao = mockk()
    private lateinit var weatherCacheSource: WeatherCacheSource

    @Before
    fun setUp() {
        weatherCacheSource = WeatherCacheSourceImpl(weatherDao)
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @After
    fun tearDown() {
        RxJavaPlugins.setIoSchedulerHandler { null }
    }

    @Test
    fun `get weather from cache source should return list of weather`() {
        // given
        val city = "denpasar"
        every { weatherDao.getForecastById(city) } returns Single.just(forecastCache)

        // when
        val weathersResult = weatherCacheSource.getWeathers(city).test()

        // then
        weathersResult.assertValue(forecastCache)
    }
}