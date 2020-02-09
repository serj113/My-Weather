package com.example.myweather.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "forecast")
data class ForecastCache(
    @PrimaryKey
    @ColumnInfo(name = "forecastid")
    var id: String = UUID.randomUUID().toString(),
    var cod : Int = 0,
    var message : Int = 0,
    var cnt : Int = 0
)

fun ForecastCache.mapToRemote(): ForecastRemote = ForecastRemote()