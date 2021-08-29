package com.example.thunderclouds

import android.Manifest
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import com.example.thunderclouds.network.ForecastJSON
import com.example.thunderclouds.presentation.MainActivity

fun MainActivity.setTransparentStatusBar() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

    }
}

fun MainActivity.enableLocationTracking() {

    if (ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {

        requestPermissions(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            MainActivity.REQUEST_LOCATION_PERMISSION
        )

    }
    else {

        if(location == null){
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0L,
                10000.0f,
                this
            )
        }


    }
}


fun ForecastJSON.asDatabaseModel() : Forecast<City> {

    return Forecast(city = Minsk())
}


