package com.example.myweather.injection

import android.app.Application
import com.example.myweather.injection.module.ApplicationModule
import com.example.myweather.injection.module.DataSourceModule
import com.example.myweather.injection.module.PersistenceModule
import com.example.myweather.injection.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (ApplicationModule::class),
    (DataSourceModule::class),
    (RepositoryModule::class),
    (PersistenceModule::class)
])
interface Injector : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): Injector
    }

    override fun inject(instance: DaggerApplication)
}