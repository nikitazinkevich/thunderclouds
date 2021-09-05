package com.example.core.interactors

import com.example.core.domain.Forecast

interface Interactors {

    suspend fun getForecastFor(latitude: Double, longitude: Double) : Forecast
}