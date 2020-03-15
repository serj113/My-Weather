package com.example.myweather.ui.model

import com.example.myweather.domain.entity.ListWeather
import java.text.SimpleDateFormat
import java.util.*

data class Weather (
    val day: String,
    val temp: Double
)

fun ListWeather.toWeather(): Weather {
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dt_txt)
    val day = SimpleDateFormat("EEEE", Locale.getDefault()).format(date)
    return Weather(
        day,
        main.temp
    )
}