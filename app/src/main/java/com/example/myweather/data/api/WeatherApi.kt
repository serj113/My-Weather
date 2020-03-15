package com.example.myweather.data.api

import com.example.myweather.data.API_KEY
import com.example.myweather.data.model.ForecastRemote
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast")
    fun getForecast(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = API_KEY
    ): Single<ForecastRemote>
}