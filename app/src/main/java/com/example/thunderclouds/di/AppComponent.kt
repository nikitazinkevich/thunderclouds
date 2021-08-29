package com.example.thunderclouds.di

import android.content.Context
import com.example.thunderclouds.ThundercloudsApp
import com.example.thunderclouds.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, NetworkModule::class, ConfigurationModule::class])
interface AppComponent : AndroidInjector<ThundercloudsApp> {

    @Component.Builder
    interface Builder {

        fun context(@BindsInstance application: Context): Builder
        fun build(): AppComponent

    }
}