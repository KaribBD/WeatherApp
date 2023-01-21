package com.example.weatherapp.dataRemote.models

import com.squareup.moshi.Json

data class HourlyWeatherResponseModel(
    @Json(name = "elevation")
    val elevation: Double,
    @Json(name = "generationtime_ms")
    val generationtime_ms: Double,
    @Json(name = "hourly")
    val hourly: Hourly,
    @Json(name = "hourly_units")
    val hourly_units: HourlyUnits,
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

data class HourlyUnits(
    @Json(name = "apparent_temperature")
    val apparent_temperature: String,
    @Json(name = "temperature_2m")
    val temperature_2m: String,
    @Json(name = "time")
    val time: String
)

data class Hourly(
    @Json(name = "apparent_temperature")
    val apparent_temperature: List<Double>,
    @Json(name = "temperature_2m")
    val temperature_2m: List<Double>,
    @Json(name = "time")
    val time: List<String>
)