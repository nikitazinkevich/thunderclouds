package com.example.thunderclouds.presentation.screens.dailyforecast

import androidx.lifecycle.ViewModel
import com.example.thunderclouds.di.ViewModelBuilder
import com.example.thunderclouds.di.ViewModelFactory
import com.example.thunderclouds.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface DailyForecastFragmentModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    fun dailyForecastFragment() : DailyForecastFragment


    @Binds
    @IntoMap
    @ViewModelKey(DailyForecastViewModel::class)
    fun dailyViewModel(dailyForecastViewModel: DailyForecastViewModel) : ViewModel


}