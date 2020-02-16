package com.example.myweather.injection.module

import com.example.myweather.weatherlist.WeatherListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeWeatherListFragment(): WeatherListFragment
}