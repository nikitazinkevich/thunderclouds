package com.example.thunderclouds

interface Configuration {

    companion object{
           const val BASE_URL = BuildConfig.BASE_URL
           const val API_KAY = BuildConfig.API_KEY
    }
    val readTimeout : Long

    val writeTimeout : Long

    val connectTimeout : Long


}