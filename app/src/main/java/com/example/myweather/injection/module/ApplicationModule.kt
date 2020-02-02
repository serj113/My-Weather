package com.example.myweather.injection.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    /**
     * Provides the application.
     * @return the application.
     */
    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Application {
        return application
    }
}