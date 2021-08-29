package com.example.thunderclouds.presentation

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


class MainActivity : AppCompatActivity(), LocationListener {

    lateinit var mainActivityViewModel: MainActivityViewModel

    var location: Location? = null
    lateinit var locationManager: LocationManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        setTransparentStatusBar()
        enableLocationTracking()


        Log.i(LOG_TAG, "Activity::onCreate()")

    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TAG, "Activity::onResume()")

    }


    override fun onLocationChanged(p0: Location) {
        location = p0

        Log.i(LOG_TAG, "${location?.latitude}\t ${location?.longitude}")


    }

    override fun onProviderDisabled(provider: String) {

    }

    override fun onProviderEnabled(provider: String) {
        enableLocationTracking()
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

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
                location = null
            }
        }

    }


    companion object {
        const val REQUEST_LOCATION_PERMISSION = 1

        val LOG_TAG: String = MainActivity::class.java.simpleName

    }


}

