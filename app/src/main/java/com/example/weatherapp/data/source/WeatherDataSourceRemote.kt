package com.example.weatherapp.data.source

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.DailyWeatherEntity
import com.example.weatherapp.data.model.HourlyWeatherEntity
import com.example.weatherapp.data.repository.WeatherRemote
import javax.inject.Inject

class WeatherDataSourceRemote @Inject constructor(
    private val remoteInfoHourRemote: WeatherRemote
) : WeatherRemote {

    override suspend fun getHourlyWeather(coordinates: CoordinatesEntity): List<HourlyWeatherEntity> {
        return remoteInfoHourRemote.getHourlyWeather(coordinates)
    }

    override suspend fun getDailyWeather(coordinates: CoordinatesEntity): List<DailyWeatherEntity> {
        return remoteInfoHourRemote.getDailyWeather(coordinates)
    }

}