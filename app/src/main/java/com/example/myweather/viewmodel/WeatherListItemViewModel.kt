package com.example.myweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myweather.base.BaseViewModel
import com.example.myweather.weatherlist.dummy.DummyContent

class WeatherListItemViewModel : BaseViewModel() {
    private val time = MutableLiveData<String>()
    private val degree = MutableLiveData<Int>()

    fun bind(item: DummyContent.DummyItem) {
        time.value = item.content
        degree.value = item.id.toInt()
    }

    fun getTime(): LiveData<String> {
        return time
    }

    fun getDegree(): LiveData<Int> {
        return degree
    }
}