package com.example.weatherapp.dataRemote.mappers

import com.example.weatherapp.data.model.HourlyWeatherEntity
import com.example.weatherapp.dataRemote.models.Hourly
import javax.inject.Inject

class HourlyWeatherEntityMapper @Inject constructor()
    : EntityMapper<Hourly, ArrayList<HourlyWeatherEntity>> {


    override fun mapFromModel(model: Hourly): ArrayList<HourlyWeatherEntity> {
        val result: ArrayList<HourlyWeatherEntity> = arrayListOf()

        model.time.forEachIndexed { index, value ->
            result.add(
                HourlyWeatherEntity(
                    hour = value,
                    temperature = model.temperature_2m[index]
                )
            )
        }

        return result
    }

}