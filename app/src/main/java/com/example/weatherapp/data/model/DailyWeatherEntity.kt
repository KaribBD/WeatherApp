package com.example.weatherapp.data.model

data class DailyWeatherEntity(
    val time: String,
    val weatherCode: Int,
    val temperature_max: Double,
    val temperature_min: Double,
    val sunrise: String,
    val sunset: String
)