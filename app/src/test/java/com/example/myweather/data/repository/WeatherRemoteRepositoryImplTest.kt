package com.example.myweather.data.repository

import com.example.myweather.data.source.WeatherCacheSource
import com.example.myweather.data.source.WeatherRemoteSource
import com.example.myweather.domain.entity.forecast
import com.example.myweather.domain.repository.WeatherRepository
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class WeatherRemoteRepositoryImplTest {

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
        val city = "denpasar"
        every { repo.getWeathers(city) } returns Single.just(forecast)

        // when
        val forecastResult = repo.getWeathers(city).test()

        // then
        forecastResult.assertValue(forecast)
    }
}