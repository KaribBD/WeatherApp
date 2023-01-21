package com.example.weatherapp.domain.models

data class DayWeather(
    val time: String,
    val weatherCode: Int,
    val temperature_max: Double,
    val temperature_min: Double,
    val sunrise: String,
    val sunset: String
)