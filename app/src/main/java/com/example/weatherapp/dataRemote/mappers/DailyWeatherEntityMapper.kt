package com.example.weatherapp.dataRemote.mappers

import com.example.weatherapp.data.model.DailyWeatherEntity
import com.example.weatherapp.data.model.HourlyWeatherEntity
import com.example.weatherapp.dataRemote.models.Daily
import javax.inject.Inject

class DailyWeatherEntityMapper @Inject constructor()
    : EntityMapper<Daily, ArrayList<DailyWeatherEntity>> {

    override fun mapFromModel(model: Daily): ArrayList<DailyWeatherEntity> {

        val result: ArrayList<DailyWeatherEntity> = arrayListOf()

        model.time.forEachIndexed { index, value ->
            result.add(
                DailyWeatherEntity(
                    time = value,
                    weatherCode = model.weathercode[index],
                    temperature_max = model.temperature_2m_max[index],
                    temperature_min = model.temperature_2m_min[index],
                    sunrise = model.sunrise[index],
                    sunset = model.sunset[index]
                )
            )
        }

        return result
    }

}