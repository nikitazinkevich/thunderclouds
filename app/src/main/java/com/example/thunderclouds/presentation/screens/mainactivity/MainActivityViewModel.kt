package com.example.thunderclouds.presentation.screens.mainactivity

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainActivityViewModel : ViewModel() {



    var location = MutableLiveData<Location>()

    //val location: LiveData<Location>()





}