package com.example.core

import com.example.core.interactors.ForecastFacade
import com.example.core.interactors.ForecastFacadeImpl
import com.example.core.interactors.GetForecastUseCase
import com.example.core.interactors.UseCase
import dagger.Binds
import dagger.Module

@Module
interface CoreModule {


    @Binds
    fun bindGetForeCastUseCase(getForecastUseCase: GetForecastUseCase) : UseCase


    @Binds
    fun bindForecastFacade(forecastFacadeImpl: ForecastFacadeImpl) : ForecastFacade


}