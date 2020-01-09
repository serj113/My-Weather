package com.example.myweather.injection.module

import com.example.myweather.data.datasource.cache.WeatherCacheSourceImpl
import com.example.myweather.data.datasource.remote.WeatherRemoteSourceImpl
import com.example.myweather.data.source.WeatherCacheSource
import com.example.myweather.data.source.WeatherRemoteSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataSourceModule {
    /**
     * Provides the WeatherCacheSource implementation.
     * @return the WeatherCacheSource implementation.
     */
    @Binds
    internal abstract fun provideWeatherCacheSource(
        weatherCacheSourceImpl: WeatherCacheSourceImpl
    ): WeatherCacheSource

    /**
     * Provides the WeatherRemoteSource implementation.
     * @return the WeatherRemoteSource implementation.
     */
    @Binds
    internal abstract fun provideWeatherRemoteSource(
        weatherRemoteSourceImpl: WeatherRemoteSourceImpl
    ): WeatherRemoteSource
}