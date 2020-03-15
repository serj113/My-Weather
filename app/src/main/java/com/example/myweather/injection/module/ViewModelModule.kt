package com.example.myweather.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myweather.ui.viewmodel.ErrorViewModel
import com.example.myweather.utils.ViewModelFactory
import com.example.myweather.utils.ViewModelKey
import com.example.myweather.ui.viewmodel.WeatherListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherListViewModel::class)
    internal abstract fun bindWeatherListViewModel(weatherListViewModel: WeatherListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ErrorViewModel::class)
    internal abstract fun bindErrorViewModel(errorViewModel: ErrorViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}