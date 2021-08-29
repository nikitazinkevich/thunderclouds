package com.example.thunderclouds.presentation.screens.dailyforecast

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.thunderclouds.R
import com.example.thunderclouds.presentation.MainActivity
import com.example.thunderclouds.presentation.MainActivityViewModel
import kotlinx.serialization.ExperimentalSerializationApi


class DailyForecastFragment : Fragment() {


    private val mainActivityViewModel by activityViewModels<MainActivityViewModel>()
    private val dailyForecastViewModel by viewModels<DailyForecastViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        mainActivityViewModel.location.observe(viewLifecycleOwner, { location ->
            if (location != null) {
                dailyForecastViewModel.getCurrentWeatherFor(location)
            }
        })


        Log.i(MainActivity.LOG_TAG, "Fragment::onCreatedView()")
        // Inflate the item_daily_indicator_recycler_view for this fragment
        return inflater.inflate(R.layout.fragment_daily_forecast, container, false)
    }

    @ExperimentalSerializationApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dailyForecastViewModel.forecast.observe(viewLifecycleOwner, { forecast ->



        })



        Log.i(
            MainActivity.LOG_TAG,
            "Fragment::onViewCreated()"
        )

    }

    override fun onResume() {
        super.onResume()
        Log.i(
            MainActivity.LOG_TAG,
            "Fragment::onResume() "
        )
    }

    companion object {

        val LOG_TAG = DailyForecastFragment::class.java.simpleName
    }
}