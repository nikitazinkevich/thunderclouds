package com.example.thunderclouds.presentation.screens.dailyforecast

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.Forecast
import com.example.core.interactors.ForecastFacade
import com.example.thunderclouds.City
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class DailyForecastViewModel
    @Inject
    constructor(): ViewModel() {

    @Inject
    lateinit var forecastFacade: ForecastFacade

    private var _forecast = MutableLiveData<Forecast>()

    val forecast: LiveData<Forecast>
        get() = _forecast

    fun getCurrentWeatherFor(location: Location) {

        try {
            viewModelScope.launch {
                _forecast.value =  forecastFacade.getForecastFor(
                    latitude =  location.latitude,
                    longitude = location.longitude)
            }
//
//            viewModelScope.launch {
//                openWeatherService.getForecast(
//                    location.latitude,
//                    location.longitude)
//            }

        } catch (e: Exception) {
        
        }

    }

}