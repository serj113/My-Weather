package com.example.myweather.injection.module

import android.content.Context
import com.example.myweather.App
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {
    /**
     * Provides the application.
     * @return the application.
     */
    @Binds
    abstract fun provideApplicationContext(app: App): Context
}