package com.example.myweather.injection

import android.app.Application
import com.example.myweather.App
import com.example.myweather.injection.module.ApiModule
import com.example.myweather.injection.module.ApplicationModule
import com.example.myweather.injection.module.DataSourceModule
import com.example.myweather.injection.module.FragmentModule
import com.example.myweather.injection.module.PersistenceModule
import com.example.myweather.injection.module.RepositoryModule
import com.example.myweather.injection.module.UseCaseModule
import com.example.myweather.injection.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (ApplicationModule::class),
    (FragmentModule::class),
    (UseCaseModule::class),
    (DataSourceModule::class),
    (RepositoryModule::class),
    (PersistenceModule::class),
    (ViewModelModule::class),
    (ApiModule::class)
])
interface Injector : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): Injector
    }

    override fun inject(app: App)
}