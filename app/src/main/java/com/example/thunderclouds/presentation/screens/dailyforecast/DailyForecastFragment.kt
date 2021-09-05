package com.example.thunderclouds.presentation.screens.dailyforecast

import android.content.Context
import android.os.Bundle
import android.os.HandlerThread
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.imageLoader
import coil.load
import coil.request.ImageRequest
import com.example.thunderclouds.R
import com.example.thunderclouds.di.ViewModelFactory
import com.example.thunderclouds.presentation.screens.mainactivity.MainActivity
import com.example.thunderclouds.presentation.screens.mainactivity.MainActivityViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import java.lang.StringBuilder
import javax.inject.Inject


class DailyForecastFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mainActivityViewModel by activityViewModels<MainActivityViewModel>()

    private val dailyForecastViewModel by viewModels<DailyForecastViewModel> {
        viewModelFactory
    }

    private lateinit var currentWeatherImage: ImageView
    private lateinit var currentConditionTextView: TextView
    private lateinit var currentTemperatureTextView: TextView
    private lateinit var fragmentLayout: ConstraintLayout
    private lateinit var progressBar: ProgressBar


    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i(MainActivity.LOG_TAG, "Fragment::onCreatedView()")
        return inflater.inflate(R.layout.test_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentWeatherImage = view.findViewById(R.id.weather_image_view)
        currentConditionTextView = view.findViewById(R.id.current_condition_text_view)
        currentTemperatureTextView = view.findViewById(R.id.current_temperature_text_view)
        progressBar = view.findViewById(R.id.progress_bar)
        fragmentLayout = view.findViewById(R.id.fragment_layout)
        dailyForecastViewModel.forecast.observe(viewLifecycleOwner) { forecast ->
            forecast?.let {
                lifecycleScope.launch {
                    dailyForecastViewModel.loadWeatherIcon(currentWeatherImage,
                    forecast.url,
                    view.context)
                    currentConditionTextView.text = forecast.condition
                    currentTemperatureTextView.text = StringBuilder()
                        .append(forecast.temperature)
                        .append("\u00B0")
                }
            }
            dailyForecastViewModel.spinner.observe(viewLifecycleOwner) { spinner ->
                if (!spinner) {
                    progressBar.visibility = View.GONE
                    fragmentLayout.visibility = View.VISIBLE

                }
            }
        }

        mainActivityViewModel.location.observe(viewLifecycleOwner, { location ->
            location?.let {
                dailyForecastViewModel.getCurrentWeatherFor(location)
            }
        })

        Log.i(MainActivity.LOG_TAG, "Fragment::onViewCreated()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(
            MainActivity.LOG_TAG, "Fragment::onResume() "
        )
    }

    companion object {

        val LOG_TAG = DailyForecastFragment::class.java.simpleName
    }
}