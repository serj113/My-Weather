package com.example.myweather.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myweather.domain.entity.Forecast
import java.util.*

@Entity
data class ForecastRemote(
    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),
    var cod : Int = 0,
    var message : Int = 0,
    var cnt : Int = 0,
    var list : List<ListWeatherRemote> = listOf()
)

fun ForecastRemote.mapToDomain(): Forecast = Forecast(list.mapToDomain())