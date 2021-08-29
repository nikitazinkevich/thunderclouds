package com.example.thunderclouds

import javax.inject.Inject

class ConfigurationImpl
    @Inject constructor()
    : Configuration {

    override val readTimeout: Long
        get() = BuildConfig.READ_TIMEOUT
    override val writeTimeout: Long
        get() = BuildConfig.WRITE_TIMEOUT
    override val connectTimeout: Long
        get() = BuildConfig.CONNECT_TIMEOUT
}