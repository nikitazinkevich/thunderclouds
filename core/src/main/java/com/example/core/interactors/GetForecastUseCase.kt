package com.example.core.interactors

import com.example.core.data.ForecastRemoteDataSource
import com.example.core.domain.Forecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sun.rmi.server.Dispatcher
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class GetForecastUseCase
@Inject
constructor(private val remoteDataSource: ForecastRemoteDataSource): UseCase{


    suspend fun execute(latitude: Double, longitude: Double): Forecast =
        withContext(Dispatchers.IO) {
            remoteDataSource.getForecast(latitude, longitude)
        }


}