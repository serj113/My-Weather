package com.example.myweather.weatherlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.myweather.R
import com.example.myweather.databinding.FragmentWeatherListBinding
import com.example.myweather.utils.ViewModelFactory
import com.example.myweather.viewmodel.WeatherListViewModel

import com.example.myweather.weatherlist.dummy.DummyContent
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_weather_list.view.*
import javax.inject.Inject

class WeatherListFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

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

        if (binding.root.list is RecyclerView) {
            with(binding.root.list) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyWeatherRecyclerViewAdapter(DummyContent.ITEMS)
            }
        }
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}
