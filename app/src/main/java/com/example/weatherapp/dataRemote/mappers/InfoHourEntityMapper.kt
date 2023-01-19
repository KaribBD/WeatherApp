package com.example.weatherapp.dataRemote.mappers

import com.example.weatherapp.data.model.InfoHourEntity
import com.example.weatherapp.dataRemote.models.WeatherListItem
import javax.inject.Inject

class InfoHourEntityMapper @Inject constructor() : EntityMapper<WeatherListItem, InfoHourEntity> {

    override fun mapFromModel(model: WeatherListItem): InfoHourEntity {
        return InfoHourEntity(
            hour = model.dt.toString(),
            temperature = model.main.temp
        )
    }

}