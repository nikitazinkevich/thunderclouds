package com.example.core.interactors

import com.example.core.domain.Forecast

interface ForecastFacade {

    suspend fun getForecastFor(latitude: Double, longitude: Double) : Forecast
}