package com.example.myweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myweather.base.BaseViewModel
import com.example.myweather.domain.entity.ListWeather

class WeatherListItemViewModel : BaseViewModel() {
    private val time = MutableLiveData<String>()
    private val degree = MutableLiveData<Double>()

    fun bind(item: ListWeather) {
        time.value = item.dt_txt
        degree.value = item.main.temp
    }

    fun getTime(): LiveData<String> = time

    fun getDegree(): LiveData<Double> = degree
}