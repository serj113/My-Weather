package com.example.myweather

import com.example.myweather.injection.DaggerInjector
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class App: DaggerApplication() {

    private val injector = DaggerInjector
        .builder()
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return injector
    }
}