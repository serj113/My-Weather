package com.example.myweather.injection

import android.app.Application
import com.example.myweather.injection.module.*
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
    (FragmentModule::class),
    (UseCaseModule::class),
    (DataSourceModule::class),
    (RepositoryModule::class),
    (PersistenceModule::class),
    (ViewModelModule::class)
])
interface Injector : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): Injector
    }

    override fun inject(instance: DaggerApplication)
}