package com.example.myweather.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myweather.base.BaseViewModel
import com.example.myweather.domain.entity.ListWeather
import com.example.myweather.ui.model.Weather

class WeatherListItemViewModel : BaseViewModel() {
    private val time = MutableLiveData<String>()
    private val degree = MutableLiveData<Double>()

    fun bind(item: Weather) {
        time.value = item.day
        degree.value = item.temp
    }

    fun getTime(): LiveData<String> = time

    fun getDegree(): LiveData<Double> = degree
}