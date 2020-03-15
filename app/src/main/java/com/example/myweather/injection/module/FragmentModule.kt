package com.example.myweather.injection.module

import com.example.myweather.ui.error.ErrorFragment
import com.example.myweather.ui.loading.LoadingFragment
import com.example.myweather.ui.weatherlist.WeatherListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeWeatherListFragment(): WeatherListFragment

    @ContributesAndroidInjector
    internal abstract fun contributeLoadingFragment(): LoadingFragment

    @ContributesAndroidInjector
    internal abstract fun contributeErrorFragment(): ErrorFragment
}