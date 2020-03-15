package com.example.myweather.ui.viewmodel

import androidx.lifecycle.LiveData
import com.example.myweather.base.BaseViewModel
import com.example.myweather.utils.Event
import com.example.myweather.utils.SingleLiveEvent
import javax.inject.Inject

class ErrorViewModel @Inject constructor() : BaseViewModel() {
    private val isRetry = SingleLiveEvent<Event<Boolean>>()

    fun retry() {
        isRetry.value = Event(true)
    }

    fun isRetry(): LiveData<Event<Boolean>> = isRetry
}