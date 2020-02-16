package com.example.myweather.injection.module

import com.example.myweather.domain.interactor.WeatherUseCase
import com.example.myweather.domain.usecase.WeatherUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {
    @Binds
    internal abstract fun provideWeatherUseCase(weatherUseCaseImpl: WeatherUseCaseImpl): WeatherUseCase
}