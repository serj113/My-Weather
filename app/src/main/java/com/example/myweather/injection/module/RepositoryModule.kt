package com.example.myweather.injection.module

import com.example.myweather.data.repository.WeatherRepositoryImpl
import com.example.myweather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    /**
     * Provides the WeatherCacheSource implementation.
     * @return the WeatherCacheSource implementation.
     */
    @Binds
    internal abstract fun provideWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}