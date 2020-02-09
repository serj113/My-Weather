package com.example.myweather.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherCache (
    @PrimaryKey
    @ColumnInfo(name = "weatherid")
    var id : Int,
    var listWeatherId : Int,
    var main : String,
    var description : String,
    var icon : String
)