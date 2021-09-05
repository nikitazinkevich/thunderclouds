package com.example.thunderclouds.presentation.network

import android.util.Log
import com.example.thunderclouds.Configuration
import com.example.thunderclouds.presentation.screens.mainactivity.MainActivity
import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {



    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()

        Log.i(MainActivity.LOG_TAG, request.toString())


        request =  request.newBuilder().header("X-Yandex-API-Key", Configuration.API_KAY).build()
        Log.i(MainActivity.LOG_TAG,  request.headers().toString())


        return chain.proceed(request)
    }

    companion object {

        val LOG_TAG: String = LoggingInterceptor::class.java.simpleName
    }
}