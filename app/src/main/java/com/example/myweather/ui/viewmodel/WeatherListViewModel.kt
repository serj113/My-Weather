package com.example.myweather.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myweather.base.BaseViewModel
import com.example.myweather.domain.interactor.WeatherUseCase
import com.example.myweather.ui.model.Weather
import com.example.myweather.ui.model.toWeather
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class WeatherListViewModel
@Inject
constructor(private val weatherUseCase: WeatherUseCase) : BaseViewModel() {
    private val weathers = MutableLiveData<List<Weather>>()

    fun fetchForecast(city: String) {
        addDisposable(
            weatherUseCase.getWeathers(city)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        weathers.value = result.weathers
                            .filterIndexed { idx, _ -> idx % 8 == 0 }
                            .map { it.toWeather() }
                    },
                    {

                    }
                )
        )
    }

    fun getWeathers(): LiveData<List<Weather>> = weathers

    override fun onCleared() {
        super.onCleared()
        Log.d("tada", "tada")
    }
}