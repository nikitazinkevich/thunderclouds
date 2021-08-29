package com.example.thunderclouds.presentation.screens.dailyforecast

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thunderclouds.City
import com.example.thunderclouds.Forecast
import kotlinx.serialization.ExperimentalSerializationApi
import java.lang.Exception

class DailyForecastViewModel() : ViewModel() {


    private var _forecast = MutableLiveData<Forecast<City>>()

    val forecast: LiveData<Forecast<City>>
        get() = _forecast

    @OptIn(ExperimentalSerializationApi::class)
    fun getCurrentWeatherFor(location: Location) {

        try {
//            viewModelScope.launch {
//                openWeatherService.getForecast(
//                    location.latitude,
//                    location.longitude)
//            }

        } catch (e: Exception) {
        
        }

    }

}