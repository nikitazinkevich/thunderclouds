package com.example.thunderclouds.network


import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {


    @GET("/v2/informers")
    suspend fun getForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("lang") language: String = "ru_RU",
    ): ResponseJson


}


