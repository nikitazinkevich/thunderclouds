package com.example.thunderclouds.di

import android.content.Context
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.example.core.CoreModule
import com.example.thunderclouds.ThundercloudsApp
import com.example.thunderclouds.presentation.network.NetworkModule
import com.example.thunderclouds.presentation.screens.dailyforecast.DailyForecastFragmentModule
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        ConfigurationModule::class,
        CoreModule::class,
        DailyForecastFragmentModule::class]
)
interface AppComponent : AndroidInjector<ThundercloudsApp> {

    @Component.Builder
    interface Builder {

        fun context(@BindsInstance application: Context): Builder
        fun build(): AppComponent

    }


}