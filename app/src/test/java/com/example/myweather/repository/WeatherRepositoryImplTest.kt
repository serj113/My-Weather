package com.example.myweather.repository

import com.example.myweather.domain.Weather
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import org.junit.Before

import org.junit.Test

class WeatherRepositoryImplTest {

    lateinit var repo: WeatherRepository

    @Before
    fun setUp() {
        repo = WeatherRepositoryImpl()
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