package com.example.thunderclouds.presentation.screens.dailyforecast

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.thunderclouds.R
import com.example.thunderclouds.di.ViewModelFactory
import com.example.thunderclouds.presentation.screens.mainactivity.MainActivity
import com.example.thunderclouds.presentation.screens.mainactivity.MainActivityViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject


class DailyForecastFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mainActivityViewModel by activityViewModels<MainActivityViewModel>()

    private val dailyForecastViewModel by viewModels<DailyForecastViewModel>{
        viewModelFactory
    }




    private lateinit var currentConditionTextView: TextView
    private lateinit var currentTemperatureTextView: TextView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i(MainActivity.LOG_TAG, "Fragment::onCreatedView()")
        return inflater.inflate(R.layout.fragment_daily_forecast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentConditionTextView = view.findViewById(R.id.current_condition_text_view)
        currentTemperatureTextView = view.findViewById(R.id.current_temperature_text_view)

        dailyForecastViewModel.forecast.observe(viewLifecycleOwner, { forecast ->

                forecast?.let {
                    currentConditionTextView.text = forecast.condition
                    currentTemperatureTextView.text = forecast.temperature.toString()

                }

        })

        mainActivityViewModel.location.observe(viewLifecycleOwner, { location ->
           location?.let {
                dailyForecastViewModel.getCurrentWeatherFor(location)
            }
        })

        Log.i(MainActivity.LOG_TAG, "Fragment::onViewCreated()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(MainActivity.LOG_TAG, "Fragment::onResume() "
        )
    }

    companion object {

        val LOG_TAG = DailyForecastFragment::class.java.simpleName
    }
}