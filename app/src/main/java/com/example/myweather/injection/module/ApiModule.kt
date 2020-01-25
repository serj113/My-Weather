package com.example.myweather.injection.module

import com.example.myweather.data.API_URL
import com.example.myweather.data.api.WeatherApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    /**
     * Provides the OkHttp client.
     * @return the OkHttp client implementation.
     */
    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    /**
     * Provides the Retrofit object.
     * @param okHttpClient the OkHttpClient object used to instantiate the retrofit
     * @return the Retrofit object
     */
    @Provides
    @Singleton
    internal fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    /**
     * Provides the WeatherRemote service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the WeatherRemote service implementation.
     */
    @Provides
    @Singleton
    internal fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}