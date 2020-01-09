package com.example.myweather.injection

import com.example.myweather.injection.module.DataSourceModule
import com.example.myweather.injection.module.RepositoryModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (DataSourceModule::class),
    (RepositoryModule::class)
])
interface Injector : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        fun build(): Injector
    }

    override fun inject(instance: DaggerApplication)
}