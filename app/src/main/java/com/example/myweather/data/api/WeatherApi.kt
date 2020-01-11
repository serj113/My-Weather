package com.example.myweather.data.api

import com.example.myweather.data.API_KEY
import com.example.myweather.data.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast")
    fun getForecast(
        @Query("q") city: String,
        @Query("APPID") apiKey: String = API_KEY
    ): Observable<Response>
}