package com.example.thunderclouds

import android.app.Application
import android.util.Log
import com.example.core.data.ForecastRemoteDataSource
import com.example.thunderclouds.di.DaggerAppComponent
import com.example.thunderclouds.network.WeatherService
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

class ThundercloudsApp : DaggerApplication() {

    private val applicationScope = CoroutineScope(Dispatchers.IO + Job())



    override fun onCreate() {
        super.onCreate()


    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>  =
        DaggerAppComponent.builder().context(applicationContext).build()



    companion object {
       private val LOG_TAG = ThundercloudsApp::class.java.simpleName
    }
}