package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.model.DailyWeatherEntity
import com.example.weatherapp.domain.models.DayWeather
import javax.inject.Inject

class DailyWeatherMapper @Inject constructor() : Mapper<DailyWeatherEntity, DayWeather> {

    override fun mapFromEntity(type: DailyWeatherEntity): DayWeather {
        return DayWeather(
            time = type.time,
            weatherCode = type.weatherCode,
            temperature_max = type.temperature_max,
            temperature_min = type.temperature_min,
            sunrise = type.sunrise,
            sunset = type.sunset
        )
    }

    override fun mapToEntity(type: DayWeather): DailyWeatherEntity {
        return DailyWeatherEntity(
            time = type.time,
            weatherCode = type.weatherCode,
            temperature_max = type.temperature_max,
            temperature_min = type.temperature_min,
            sunrise = type.sunrise,
            sunset = type.sunset
        )
    }

}