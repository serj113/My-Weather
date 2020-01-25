package com.example.myweather.domain.usecase

import com.example.myweather.domain.entity.forecast
import com.example.myweather.domain.interactor.WeatherUseCase
import com.example.myweather.domain.repository.WeatherRepository
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class WeatherRemoteUseCaseImplTest {

    private val repository: WeatherRepository = mockk()

    private lateinit var useCase: WeatherUseCase

    @Before
    fun setUp() {
        useCase = WeatherUseCaseImpl(repository)
    }

    @Test
    fun `use case getWeathers should return list of weathers`() {
        // given
        val city = "denpasar"
        every { repository.getWeathers(city) } returns Single.just(forecast)

        // when
        val forecastResult = useCase.getWeathers(city).test()

        // then
        forecastResult.assertValue(forecast)
    }

}