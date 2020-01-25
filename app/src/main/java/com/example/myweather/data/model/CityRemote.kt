package com.example.myweather.data.model

data class CityRemote (
    val id : Int,
    val name : String,
    val coord : CoordRemote,
    val country : String,
    val population : Int,
    val timezone : Int,
    val sunrise : Int,
    val sunset : Int
)