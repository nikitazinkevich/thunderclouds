package com.example.core.interactors

import com.example.core.domain.Forecast
import javax.inject.Inject
import javax.inject.Provider

class ForecastFacadeImpl

@Inject constructor() : ForecastFacade{

    @Inject
    lateinit var getForecastUseCase: Provider<GetForecastUseCase>
    override suspend fun getForecastFor(latitude: Double, longitude: Double) : Forecast {
      return  getForecastUseCase.get().execute(latitude,longitude)
    }
}