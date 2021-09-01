package com.example.core.data

import com.example.core.domain.Forecast

interface ForecastRemoteDataSource {


    suspend fun getForecast(latitude: Double, longitude: Double) : Forecast
}