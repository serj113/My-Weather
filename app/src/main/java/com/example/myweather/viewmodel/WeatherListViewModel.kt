package com.example.myweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myweather.base.BaseViewModel
import com.example.myweather.domain.entity.Forecast
import com.example.myweather.domain.interactor.WeatherUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherListViewModel
@Inject
constructor(private val weatherUseCase: WeatherUseCase) : BaseViewModel() {
    private val forecast = MutableLiveData<Forecast>()

    fun fetchForecast(city: String) {
        addDisposable(
            weatherUseCase.getWeathers(city)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        forecast.value = it
                    },
                    {

                    }
                )
        )
    }

    fun getForecast(): LiveData<Forecast> = forecast
}