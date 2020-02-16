package com.example.myweather.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.myweather.base.BaseViewModel
import com.example.myweather.domain.entity.Forecast
import com.example.myweather.domain.interactor.WeatherUseCase
import javax.inject.Inject

class WeatherListViewModel
@Inject
constructor(private val weatherUseCase: WeatherUseCase) : BaseViewModel() {
    private val forecast = MutableLiveData<Forecast>()
}