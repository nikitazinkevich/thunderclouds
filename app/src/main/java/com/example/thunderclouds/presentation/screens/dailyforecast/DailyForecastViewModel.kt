package com.example.thunderclouds.presentation.screens.dailyforecast

import android.content.Context
import android.location.Location
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.example.core.domain.Forecast
import com.example.core.interactors.Interactors
import dagger.Provides
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

class DailyForecastViewModel
@Inject
constructor(private val interactors: Interactors) : ViewModel() {

    private var _spinner = MutableLiveData(true)
    val spinner: LiveData<Boolean>
        get() = _spinner


    private var _forecast = MutableLiveData<Forecast>()
    val forecast: LiveData<Forecast>
        get() = _forecast


    fun getCurrentWeatherFor(location: Location) {

        try {
            viewModelScope.launch {
                if(isActive){
                    _forecast.value = interactors.getForecastFor(
                        latitude = location.latitude,
                        longitude = location.longitude
                    )
                    _spinner.value = false
                }
            }


        } catch (e: Exception) {
            e.message?.let { Log.i( DailyForecastViewModel::class.java.simpleName, it) }
        }

    }

    suspend fun loadWeatherIcon(to: ImageView, icon: String, context: Context){
        withContext(Dispatchers.IO){
            to.load("https://yastatic.net/weather/i/icons/funky/dark/${icon}.svg"){
                decoder(SvgDecoder(context))
                crossfade(750)
            }
        }

    }
    override fun onCleared() {

        viewModelScope.cancel()
        _spinner.value = true
    }

}