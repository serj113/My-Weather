package com.example.myweather.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myweather.ui.viewmodel.ErrorViewModel
import com.example.myweather.utils.ViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<VM: BaseViewModel> : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var vm: VM

    protected abstract fun initVM()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        initVM()
    }
}