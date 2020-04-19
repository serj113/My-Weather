package com.example.myweather.ui.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myweather.base.BaseFragment
import com.example.myweather.databinding.FragmentLoadingBinding
import com.example.myweather.ui.viewmodel.WeatherListViewModel
import com.example.myweather.utils.goTo
import com.example.myweather.utils.isTrue

class LoadingFragment : BaseFragment<WeatherListViewModel>() {

    override fun initVM() {
        vm = ViewModelProviders.of(requireActivity(), viewModelFactory).get(WeatherListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoadingBinding.inflate(inflater, container, false)
        binding.viewModel = vm
        binding.lifecycleOwner = this

        vm.getWeathers().observe(viewLifecycleOwner, Observer {
            goTo(LoadingFragmentDirections.actionLoadingFragmentToWeatherListFragment())
        })
        vm.isError().observe(viewLifecycleOwner, Observer {
            if (it.isTrue()) {
                goTo(LoadingFragmentDirections.actionLoadingFragmentToErrorFragment())
            }
        })
        vm.fetchForecast("Jakarta")

        return binding.root
    }
}
