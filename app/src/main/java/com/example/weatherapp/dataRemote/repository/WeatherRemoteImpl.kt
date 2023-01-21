package com.example.weatherapp.dataRemote.repository

import android.util.Log
import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.DailyWeatherEntity
import com.example.weatherapp.data.model.HourlyWeatherEntity
import com.example.weatherapp.data.repository.WeatherRemote
import com.example.weatherapp.dataRemote.api.WeatherService
import com.example.weatherapp.dataRemote.mappers.DailyWeatherEntityMapper
import com.example.weatherapp.dataRemote.mappers.HourlyWeatherEntityMapper
import javax.inject.Inject

class WeatherRemoteImpl @Inject constructor(
    private val weatherService: WeatherService,
    private val hourlyWeatherEntityMapper: HourlyWeatherEntityMapper,
    private val dailyWeatherEntityMapper: DailyWeatherEntityMapper
) : WeatherRemote {

    override suspend fun getHourlyWeather(coordinates: CoordinatesEntity): List<HourlyWeatherEntity> {
        val hourlyParams = arrayListOf(
            "temperature_2m",
            "apparent_temperature"
        )
            .joinToString(separator = ",")

        val response = weatherService.getHourlyWeather(
            coordinates.latitude,
            coordinates.longitude,
            hourlyParams
        )

        Log.i("getHourlyWeather() = \n", response.toString())

        return hourlyWeatherEntityMapper.mapFromModel(response.hourly)
    }

    override suspend fun getDailyWeather(coordinates: CoordinatesEntity): List<DailyWeatherEntity> {

        val dailyParams = arrayListOf(
            "weathercode",
            "temperature_2m_max",
            "temperature_2m_min",
            "sunrise",
            "sunset"
        )
            .joinToString(separator = ",")

        val response = weatherService.getDailyWeather(
            coordinates.latitude,
            coordinates.longitude,
            dailyParams,
            "America%2FLos_Angeles" //todo change to real timezone
        )

        Log.i("getDailyWeather() =\n", response.toString())

        return dailyWeatherEntityMapper.mapFromModel(response.daily)
    }

}