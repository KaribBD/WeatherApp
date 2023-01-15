package com.example.weatherapp.domain.models

data class InfoDay(
    val date: String,
    val dayOfWeek: String,
    val dayTemperature: Int,
    val nightTemperature: Int
)