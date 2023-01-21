package com.example.weatherapp.dataRemote.models
import com.squareup.moshi.Json


data class DailyWeatherResponseModel(
    @Json(name = "daily")
    val daily: Daily,
    @Json(name = "daily_units")
    val daily_units: DailyUnits,
    @Json(name = "elevation")
    val elevation: Double,
    @Json(name = "generationtime_ms")
    val generationtime_ms: Double,
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "timezone_abbreviation")
    val timezone_abbreviation: String,
    @Json(name = "utc_offset_seconds")
    val utc_offset_seconds: Int
)

data class Daily(
    @Json(name = "sunrise")
    val sunrise: List<String>,
    @Json(name = "sunset")
    val sunset: List<String>,
    @Json(name = "temperature_2m_max")
    val temperature_2m_max: List<Double>,
    @Json(name = "temperature_2m_min")
    val temperature_2m_min: List<Double>,
    @Json(name = "time")
    val time: List<String>,
    @Json(name = "weathercode")
    val weathercode: List<Int>
)

data class DailyUnits(
    @Json(name = "sunrise")
    val sunrise: String,
    @Json(name = "sunset")
    val sunset: String,
    @Json(name = "temperature_2m_max")
    val temperature_2m_max: String,
    @Json(name = "temperature_2m_min")
    val temperature_2m_min: String,
    @Json(name = "time")
    val time: String,
    @Json(name = "weathercode")
    val weathercode: String
)