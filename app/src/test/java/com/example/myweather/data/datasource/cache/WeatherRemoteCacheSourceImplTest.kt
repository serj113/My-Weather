package com.example.myweather.data.datasource.cache

import com.example.myweather.data.model.ForecastRemote
import com.example.myweather.data.source.WeatherCacheSource
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import org.junit.Before
import org.junit.Test

class WeatherRemoteCacheSourceImplTest {
    private lateinit var weatherCacheSource: WeatherCacheSource

    @Before
    fun setUp() {
        weatherCacheSource = WeatherCacheSourceImpl()
    }

    @Test
    fun `get weather from cache source should return list of weather`() {
        // given
        val city = "denpasar"
        val weathersResponse = listOf<ForecastRemote>()

        // when
        val weathers = weatherCacheSource.getWeathers(city)

        // then
        assertThat(weathers, hasSize(equalTo(weathersResponse.size)))
    }
}