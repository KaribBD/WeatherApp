package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.model.HourlyWeatherEntity
import com.example.weatherapp.domain.models.HourWeather
import javax.inject.Inject

class HourlyWeatherMapper @Inject constructor() : Mapper<HourlyWeatherEntity, HourWeather> {

    override fun mapFromEntity(type: HourlyWeatherEntity): HourWeather {
        return HourWeather(
            hour = type.hour,
            temperature = type.temperature
        )
    }

    override fun mapToEntity(type: HourWeather): HourlyWeatherEntity {
        return HourlyWeatherEntity(
            hour = type.hour,
            temperature = type.temperature
        )
    }

}