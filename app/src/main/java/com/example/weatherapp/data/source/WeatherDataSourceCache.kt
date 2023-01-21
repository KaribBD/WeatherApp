package com.example.weatherapp.data.source

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.DailyWeatherEntity
import com.example.weatherapp.data.model.HourlyWeatherEntity
import com.example.weatherapp.data.repository.WeatherCache
import javax.inject.Inject

class WeatherDataSourceCache @Inject constructor(
    infoHourCache: WeatherCache
) : WeatherCache {

    override suspend fun getHourlyWeather(coordinates: CoordinatesEntity): List<HourlyWeatherEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getDailyWeather(coordinates: CoordinatesEntity): List<DailyWeatherEntity> {
        TODO("Not yet implemented")
    }

}