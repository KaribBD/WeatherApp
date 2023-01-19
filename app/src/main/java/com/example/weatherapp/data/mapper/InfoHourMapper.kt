package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.model.InfoHourEntity
import com.example.weatherapp.domain.models.InfoHour
import javax.inject.Inject

class InfoHourMapper @Inject constructor() : Mapper<InfoHourEntity, InfoHour> {

    override fun mapFromEntity(type: InfoHourEntity): InfoHour {
        return InfoHour(
            hour = type.hour,
            temperature = type.temperature
        )
    }

    override fun mapToEntity(type: InfoHour): InfoHourEntity {
        return InfoHourEntity(
            hour = type.hour,
            temperature = type.temperature
        )
    }

}