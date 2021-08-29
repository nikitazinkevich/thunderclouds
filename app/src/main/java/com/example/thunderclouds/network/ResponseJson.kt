package com.example.thunderclouds.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ResponseJson(
    @SerialName("now")
    val timeOnServer: Int,
    @SerialName("now_dt")
    val timeUTC: String,
    @SerialName("info")
    val info: Info,
    @SerialName("fact")
    val fact: Fact,

    @SerialName("forecast")
    val forecast: ForecastJSON

)

@Serializable
data class Info(
    @SerialName("url")
    val url: String,
    @SerialName("lon")
    val longitude: Double,
    @SerialName("lat")
    val latitude: Double
)



@Serializable
data class Fact(
    @SerialName("obs_time")
    val obsTimer: Int,
    @SerialName("temp")
    val temperature: Int,
    @SerialName("feels_like")
    val feelsLike: Int,
    @SerialName("icon")
    val icon: String,
    @SerialName("wind_speed")
    val windSpeed: Double,
    @SerialName("wind_dir")
    val windDir: String,
    @SerialName("pressure_mm")
    val pressureMm: Int,
    @SerialName("pressure_pa")
    val pressurePa: Int,
    @SerialName("humidity")
    val humidity: Int,
    @SerialName("daytime")
    val daytime: String,
    @SerialName("polar")
    val polar: Boolean,
    @SerialName("season")
    val season: String,
    @SerialName("wind_gust")
    val windGust: Double

)

@Serializable
class ForecastJSON(
    @SerialName("date")
    val date: String,
    @SerialName("date_ts")
    val dateTs: Int,
    @SerialName("week")
    val week: Int,
    @SerialName("sunrise")
    val sunrise: String,
    @SerialName("sunset")
    val sunset: String,
    @SerialName("moon_code")
    val moonCode: Int,
    @SerialName("moon_text")
    val moonText: String,
    @SerialName("parts")
    val parts: Array<Part>

)

@Serializable
data class Part(
    @SerialName("part_name")
    val partTime: String,
    @SerialName("temp_min")
    val minTemperature: Int,
    @SerialName("temp_max")
    val maxTemperature: Int,
    @SerialName("temp_avg")
    val avgTemperature: Int,
    @SerialName("wind_speed")
    val windSpeed: Double,
    @SerialName("wind_gust")
    val windGust: Double,
    @SerialName("wind_dir")
    val windDir: String,
    @SerialName("pressure_mm")
    val pressureMm: Int,
    @SerialName("pressure_pa")
    val pressurePa: Int,
    @SerialName("humidity")
    val humidity: Int,
    @SerialName("prec_prob")
    val precProb: Double,
    @SerialName("prec_mm")
    val precMm: Double,
    @SerialName("prec_period")
    val precPeriod: Double,
    @SerialName("feels_like")
    val feelsLike: Int,
    @SerialName("icon")
    val icon: String,
    @SerialName("condition")
    val condition: String,
    @SerialName("daytime")
    val daytime: String,
    @SerialName("polar")
    val polar: Boolean

)
