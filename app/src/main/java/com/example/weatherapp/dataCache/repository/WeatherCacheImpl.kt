package com.example.weatherapp.dataCache.repository

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.DailyWeatherEntity
import com.example.weatherapp.data.model.HourlyWeatherEntity
import com.example.weatherapp.data.repository.WeatherCache
import javax.inject.Inject

class WeatherCacheImpl @Inject constructor() : WeatherCache {

    override suspend fun getHourlyWeather(coordinates: CoordinatesEntity): List<HourlyWeatherEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getDailyWeather(coordinates: CoordinatesEntity): List<DailyWeatherEntity> {
        TODO("Not yet implemented")
    }
}