package com.example.myweather.ui.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myweather.base.BaseFragment
import com.example.myweather.databinding.FragmentErrorBinding
import com.example.myweather.ui.viewmodel.ErrorViewModel
import com.example.myweather.utils.goTo
import com.example.myweather.utils.isTrue
import dagger.android.support.AndroidSupportInjection

class ErrorFragment : BaseFragment<ErrorViewModel>() {

    override fun initVM() {
        vm = ViewModelProviders.of(requireActivity(), viewModelFactory).get(ErrorViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentErrorBinding.inflate(inflater, container, false)

        binding.viewModel = vm
        binding.lifecycleOwner = this

        vm.isRetry().observe(viewLifecycleOwner, Observer {
            if (it.isTrue()) {
                goTo(ErrorFragmentDirections.actionErrorFragmentToLoadingFragment())
            }
        })

        return binding.root
    }
}
