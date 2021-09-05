package com.example.thunderclouds

import coil.ImageLoader
import coil.decode.SvgDecoder
import com.example.thunderclouds.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ThundercloudsApp : DaggerApplication() {

    private val applicationScope = CoroutineScope(Dispatchers.IO + Job())

    private lateinit var imageLoader: ImageLoader

    override fun onCreate() {
        super.onCreate()


    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>  =
        DaggerAppComponent.builder().context(applicationContext).build()



    companion object {
       private val LOG_TAG = ThundercloudsApp::class.java.simpleName
    }
}