package com.example.myweather.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val disposes = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        disposes.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposes.clear()
    }
}