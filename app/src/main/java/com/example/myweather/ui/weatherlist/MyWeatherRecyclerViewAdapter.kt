package com.example.myweather.ui.weatherlist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myweather.databinding.FragmentWeatherListItemBinding
import com.example.myweather.domain.entity.ListWeather
import com.example.myweather.ui.model.Weather
import com.example.myweather.ui.viewmodel.WeatherListItemViewModel

class MyWeatherRecyclerViewAdapter : RecyclerView.Adapter<MyWeatherRecyclerViewAdapter.ViewHolder>() {
    private var mValues: List<Weather> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentWeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mValues[position])
    }

    override fun getItemCount(): Int = mValues.size

    fun setItems(items: List<Weather>) {
       mValues = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: FragmentWeatherListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val viewModel = WeatherListItemViewModel()

        fun bind(item: Weather) {
            viewModel.bind(item)
            binding.viewModel = viewModel
        }
    }
}
