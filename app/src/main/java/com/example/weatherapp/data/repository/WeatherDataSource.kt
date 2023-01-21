package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.DailyWeatherEntity
import com.example.weatherapp.data.model.HourlyWeatherEntity

interface WeatherDataSource {
    suspend fun getHourlyWeather(coordinates: CoordinatesEntity): List<HourlyWeatherEntity>
    suspend fun getDailyWeather(coordinates: CoordinatesEntity): List<DailyWeatherEntity>
}