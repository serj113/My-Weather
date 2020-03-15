package com.example.myweather.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myweather.base.BaseViewModel
import com.example.myweather.domain.interactor.WeatherUseCase
import com.example.myweather.ui.model.Weather
import com.example.myweather.ui.model.toWeather
import com.example.myweather.utils.Event
import com.example.myweather.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.min

class WeatherListViewModel
@Inject
constructor(private val weatherUseCase: WeatherUseCase) : BaseViewModel() {
    private val currentTime = MutableLiveData<String>()
    private val currentDegree = MutableLiveData<String>()
    private val weathers = MutableLiveData<List<Weather>>()
    private val isError = SingleLiveEvent<Event<Boolean>>()

    fun fetchForecast(city: String) {
        addDisposable(
            weatherUseCase.getWeathers(city)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        val weathersResult = result.weathers
                            .filterIndexed { idx, _ -> idx % 8 == 0 }
                            .map { it.toWeather() }.toMutableList()
                        weathersResult.add(result.weathers.last().toWeather())
                        if (weathersResult.isEmpty()) {
                            isError.value = Event(true)
                        } else {
                            currentDegree.value = "${String.format("%.0f", weathersResult.first().temp)}\u00B0"
                            currentTime.value = weathersResult.first().day
                            weathers.value = weathersResult.subList(
                                min(1, weathersResult.lastIndex),
                                weathersResult.lastIndex
                            )
                        }
                    },
                    {
                        isError.value = Event(true)
                    }
                )
        )
    }

    fun getCurrentTime(): LiveData<String> = currentTime

    fun getCurrentDegree(): LiveData<String> = currentDegree

    fun getWeathers(): LiveData<List<Weather>> = weathers

    fun isError(): LiveData<Event<Boolean>> = isError
}