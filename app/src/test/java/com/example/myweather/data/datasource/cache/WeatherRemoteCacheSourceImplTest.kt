package com.example.myweather.data.datasource.cache

import com.example.myweather.data.dao.WeatherDao
import com.example.myweather.data.model.forecastRemote
import com.example.myweather.data.source.WeatherCacheSource
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class WeatherRemoteCacheSourceImplTest {
    private val weatherDao: WeatherDao = mockk()
    private lateinit var weatherCacheSource: WeatherCacheSource

    @Before
    fun setUp() {
        weatherCacheSource = WeatherCacheSourceImpl(weatherDao)
    }

    @Test
    fun `get weather from cache source should return list of weather`() {
        // given
        val city = "denpasar"
        every { weatherCacheSource.getWeathers(city) } returns Single.just(forecastRemote)

        // when
        val weathersResult = weatherCacheSource.getWeathers(city).test()

        // then
        weathersResult.assertValue(forecastRemote)
    }
}