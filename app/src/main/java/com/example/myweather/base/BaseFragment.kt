package com.example.myweather.base

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM: BaseViewModel> : Fragment() {
    protected lateinit var vm: VM

    protected abstract fun initVM()

    protected abstract fun getVM(): VM

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        initVM()
    }
}