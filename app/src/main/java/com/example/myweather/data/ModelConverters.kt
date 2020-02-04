package com.example.myweather.data

import androidx.room.TypeConverter
import com.example.myweather.data.model.ListWeatherRemote
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType


class ModelConverters {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromStringToListWeatherRemote(string: String): List<ListWeatherRemote>? {
        val type = newParameterizedType(List::class.java, ListWeatherRemote::class.java)
        val jsonAdapter: JsonAdapter<List<ListWeatherRemote>> = moshi.adapter(type)
        return jsonAdapter.fromJson(string)
    }

    @TypeConverter
    fun fromListWeatherRemoteToString(list: List<ListWeatherRemote>): String? {
        val type = newParameterizedType(List::class.java, ListWeatherRemote::class.java)
        val jsonAdapter: JsonAdapter<List<ListWeatherRemote>> = moshi.adapter(type)
        return jsonAdapter.toJson(list)
    }
}