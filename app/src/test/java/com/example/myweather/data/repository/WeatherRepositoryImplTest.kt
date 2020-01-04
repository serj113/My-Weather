package com.example.myweather.data.repository

import com.example.myweather.data.source.WeatherCacheSource
import com.example.myweather.data.source.WeatherRemoteSource
import com.example.myweather.domain.entity.Weather
import com.example.myweather.domain.repository.WeatherRepository
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class WeatherRepositoryImplTest {

    private val weatherCacheSource: WeatherCacheSource = mockk()
    private val weatherRemoteSource: WeatherRemoteSource = mockk()
    private lateinit var repo: WeatherRepository

    @Before
    fun setUp() {
        repo = WeatherRepositoryImpl(weatherCacheSource, weatherRemoteSource)
    }

    @Test
    fun `get weather should return list of weather`() {
        // given
        val weathersResponse = listOf<Weather>()

        // when
        val weathers = repo.getWeathers()

        // then
        assertThat(weathers, hasSize(equalTo(weathersResponse.size)))
    }
}