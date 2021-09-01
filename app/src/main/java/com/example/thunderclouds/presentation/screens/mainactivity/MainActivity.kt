package com.example.thunderclouds.presentation.screens.mainactivity

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.thunderclouds.R
import com.example.thunderclouds.enableLocationTracking
import com.example.thunderclouds.setTransparentStatusBar


class MainActivity : AppCompatActivity() {

    lateinit var  mainActivityViewModel: MainActivityViewModel
    lateinit var locationManager: LocationManager

    private lateinit var _locationListener: LocationListener

    val locationListener: LocationListener
        get() = _locationListener

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.i(LOG_TAG, "Activity::onAttachedToWindow()")

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        _locationListener = LocationListenerImpl { location ->
            mainActivityViewModel.location.value = location

        }
        setTransparentStatusBar()
        enableLocationTracking()


        Log.i(LOG_TAG, "Activity::onCreate()")

    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TAG, "Activity::onResume()")

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                enableLocationTracking()
            } else {
                mainActivityViewModel.location.value = null
            }
        }


    }


    private inner class LocationListenerImpl( private val action: (Location) -> Unit) :
        LocationListener {


        override fun onLocationChanged(p0: Location) {
            action(p0)
            Log.i(LOG_TAG, "${p0.latitude}\t ${p0.longitude}")

        }

        override fun onProviderDisabled(provider: String) {

        }

        override fun onProviderEnabled(provider: String) {
            if(LocationManager.GPS_PROVIDER == provider){
                enableLocationTracking()
            }
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

        }


    }


    companion object {
        const val REQUEST_LOCATION_PERMISSION = 1

        val LOG_TAG: String = MainActivity::class.java.simpleName

    }


}

