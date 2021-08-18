package com.example.thunderclouds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class DailyForecastFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the item_daily_indicator_recycler_view for this fragment
        return inflater.inflate(R.layout.fragment_daily_forecast, container, false)
    }


}