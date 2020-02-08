package com.example.myweather.data.model

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class CityRemote (
    val id : Int,
    val name : String,
    @Embedded
    val coord : CoordRemote,
    val country : String,
    val population : Int,
    val timezone : Int,
    val sunrise : Int,
    val sunset : Int
)