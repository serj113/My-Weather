package com.example.myweather.weatherlist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myweather.databinding.FragmentWeatherListItemBinding
import com.example.myweather.viewmodel.WeatherListItemViewModel


import com.example.myweather.weatherlist.dummy.DummyContent.DummyItem

class MyWeatherRecyclerViewAdapter(
    private val mValues: List<DummyItem>
) : RecyclerView.Adapter<MyWeatherRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentWeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val binding: FragmentWeatherListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val viewModel = WeatherListItemViewModel()

        fun bind(item: DummyItem) {
            viewModel.bind(item)
            binding.viewModel = viewModel
        }
    }
}
