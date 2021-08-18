package com.example.thunderclouds

import android.app.Activity
import android.os.Build
import android.view.WindowManager

fun Activity.setTransparentStatusBar() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

    }
}