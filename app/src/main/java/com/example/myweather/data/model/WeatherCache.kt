package com.example.myweather.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherCache (
    @PrimaryKey
    val id : Int,
    val listWeatherId : Int,
    val main : String,
    val description : String,
    val icon : String
)