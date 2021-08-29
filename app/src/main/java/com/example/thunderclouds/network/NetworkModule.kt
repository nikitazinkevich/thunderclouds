package com.example.thunderclouds.network

import com.example.thunderclouds.Configuration
import com.example.thunderclouds.di.BaseUrl
import com.example.thunderclouds.di.InterceptorQualifier
import com.example.thunderclouds.di.KotlinConverter
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit, service: Class<WeatherService>): WeatherService =
        retrofit.create(service)

    @Singleton
    @Provides
    fun provideWeatherServiceApi(): Class<WeatherService> = WeatherService::class.java

    @Singleton
    @Provides
    fun provideRetrofit(
        @BaseUrl
        baseUrl: String,
        @KotlinConverter
        converter: Converter.Factory,
        okHttpClient: OkHttpClient,

        ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converter)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        configuration: Configuration,
        @InterceptorQualifier("Logging")
        interceptor: Interceptor
    ): OkHttpClient =

        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(configuration.readTimeout, TimeUnit.MILLISECONDS)
            .writeTimeout(configuration.writeTimeout, TimeUnit.MILLISECONDS)
            .connectTimeout(configuration.connectTimeout, TimeUnit.MILLISECONDS)
            .build()


    @Provides
    @Singleton
    @InterceptorQualifier("Logging")
    fun provideInterceptor(): Interceptor = LoggingInterceptor()


    @ExperimentalSerializationApi
    @KotlinConverter
    @Provides
    fun provideJsonKotlinConverter(mediaType: MediaType): Converter.Factory =
        Json { ignoreUnknownKeys = true }.asConverterFactory(mediaType)

    @Provides
    fun provideConverterMediaType(): MediaType = MediaType.get("application/json")

    @Provides
    @BaseUrl
    fun provideBaseUrl(): String = Configuration.BASE_URL

}

