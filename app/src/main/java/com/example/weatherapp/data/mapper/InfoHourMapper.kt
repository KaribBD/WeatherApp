package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.model.EntityInfoHour
import com.example.weatherapp.domain.models.InfoHour
import javax.inject.Inject

class InfoHourMapper @Inject constructor() : Mapper<EntityInfoHour, InfoHour> {

    override fun mapFromEntity(type: EntityInfoHour): InfoHour {
        return InfoHour(
            hour = type.hour,
            temperature = type.temperature
        )
    }

    override fun mapToEntity(type: InfoHour): EntityInfoHour {
        return EntityInfoHour(
            hour = type.hour,
            temperature = type.temperature
        )
    }

}