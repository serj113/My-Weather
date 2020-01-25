package com.example.myweather.data.datasource.remote

import com.example.myweather.data.api.WeatherApi
import com.example.myweather.data.model.ForecastRemote
import com.example.myweather.data.model.forecastRemote
import com.example.myweather.data.source.WeatherRemoteSource
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class WeatherRemoteRemoteSourceImplTest {

    private val weatherApi: WeatherApi = mockk()
    private lateinit var weatherRemoteSource: WeatherRemoteSource

    @Before
    fun setup() {
        weatherRemoteSource = WeatherRemoteSourceImpl(weatherApi)
    }

    @Test
    fun `get weather from remote source should return list of weather`() {
        // given
        val city = "denpasar"
        every { weatherRemoteSource.getWeathers(city) } returns Single.just(forecastRemote)

        // when
        val forecastRemoteResult = weatherRemoteSource.getWeathers(city).test()

        //then
        forecastRemoteResult.assertValue(forecastRemote)
    }
}