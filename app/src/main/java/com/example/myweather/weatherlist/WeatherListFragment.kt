package com.example.myweather.weatherlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myweather.databinding.FragmentWeatherListBinding
import com.example.myweather.utils.ViewModelFactory
import com.example.myweather.viewmodel.WeatherListViewModel

import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_weather_list.view.*
import javax.inject.Inject

class WeatherListFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var adapter: MyWeatherRecyclerViewAdapter

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(WeatherListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWeatherListBinding.inflate(inflater, container, false)
        adapter = MyWeatherRecyclerViewAdapter()

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.recyclerView.also {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = adapter
        }

        viewModel.getForecast().observe(viewLifecycleOwner, Observer {
            adapter.setList(it.weathers)
        })

        viewModel.fetchForecast("Jakarta")
        return binding.root
    }
}
