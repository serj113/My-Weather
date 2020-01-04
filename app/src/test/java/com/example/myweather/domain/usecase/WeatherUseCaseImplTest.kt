package com.example.myweather.domain.usecase

import com.example.myweather.domain.entity.Weather
import com.example.myweather.domain.interactor.WeatherUseCase
import com.example.myweather.domain.repository.WeatherRepository
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class WeatherUseCaseImplTest {

    @MockK
    lateinit var repository: WeatherRepository

    private lateinit var useCase: WeatherUseCase

    @Before
    fun setUp() {
        repository = mockk()
        useCase = WeatherUseCaseImpl(repository)
    }

    @Test
    fun `use case getWeathers should return list of weathers`() {
        // given
        val weathersResponse = listOf<Weather>()
        every { repository.getWeathers() } returns listOf()

        // when
        val weathers = useCase.getWeathers()

        // then
        assertThat(weathers, hasSize(equalTo(weathersResponse.size)))
    }

}