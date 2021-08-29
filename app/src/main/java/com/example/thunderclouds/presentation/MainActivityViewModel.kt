package com.example.thunderclouds.presentation

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainActivityViewModel : ViewModel() {


    private var _location = MutableLiveData<Location>()

    val location: LiveData<Location>
        get() = _location





}