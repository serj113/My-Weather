package com.example.myweather.ui.weatherlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myweather.databinding.FragmentWeatherListBinding
import com.example.myweather.utils.ViewModelFactory
import com.example.myweather.ui.viewmodel.WeatherListViewModel

import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class WeatherListFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var adapter: MyWeatherRecyclerViewAdapter

    private val viewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory).get(WeatherListViewModel::class.java)
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

        viewModel.getWeathers().observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })

        return binding.root
    }
}
