package com.example.thunderclouds.presentation.network

import com.example.core.data.ForecastRemoteDataSource
import com.example.core.domain.Forecast
import javax.inject.Inject

class ForecastRemoteDataSourceImpl
    @Inject
    constructor(private val service: WeatherService) : ForecastRemoteDataSource {


    override suspend fun getForecast(latitude: Double, longitude: Double): Forecast {
        return service.getForecast(
            latitude = latitude,
            longitude = longitude
        ).asDomainModel()
    }
}