package com.example.myweather.ui.loading

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.myweather.databinding.FragmentLoadingBinding
import com.example.myweather.ui.viewmodel.WeatherListViewModel
import com.example.myweather.utils.ViewModelFactory
import com.example.myweather.utils.goTo
import com.example.myweather.utils.isTrue
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LoadingFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

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
        val binding = FragmentLoadingBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getWeathers().observe(viewLifecycleOwner, Observer {
            goTo(LoadingFragmentDirections.actionLoadingFragmentToWeatherListFragment())
        })
        viewModel.isError().observe(viewLifecycleOwner, Observer {
            if (it.isTrue()) {
                goTo(LoadingFragmentDirections.actionLoadingFragmentToErrorFragment())
            }
        })
        viewModel.fetchForecast("Jakarta")

        return binding.root
    }
}
