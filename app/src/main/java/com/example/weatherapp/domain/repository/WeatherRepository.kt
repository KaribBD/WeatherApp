package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.models.DayWeather
import com.example.weatherapp.domain.models.HourWeather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    //Remote
    suspend fun getHourlyWeatherList(coordinates: Coordinates): Flow<List<HourWeather>>
    suspend fun getDailyWeatherList(coordinates: Coordinates): Flow<List<DayWeather>>
}