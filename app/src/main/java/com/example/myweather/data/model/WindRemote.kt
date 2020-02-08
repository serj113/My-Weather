package com.example.myweather.data.model

import androidx.room.Entity

@Entity
data class WindRemote (
    val speed : Double,
    val deg : Int
)