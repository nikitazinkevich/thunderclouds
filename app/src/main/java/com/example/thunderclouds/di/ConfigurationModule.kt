package com.example.thunderclouds.di

import com.example.thunderclouds.Configuration
import com.example.thunderclouds.ConfigurationImpl
import dagger.Binds
import dagger.Module


@Module
interface ConfigurationModule {

    @Binds
    fun provideConfiguration(configuration: ConfigurationImpl): Configuration
}
