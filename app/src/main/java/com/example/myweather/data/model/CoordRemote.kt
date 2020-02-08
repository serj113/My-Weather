package com.example.myweather.data.model

import androidx.room.Entity

@Entity
data class CoordRemote (
    val lat : Double,
    val lon : Double
)