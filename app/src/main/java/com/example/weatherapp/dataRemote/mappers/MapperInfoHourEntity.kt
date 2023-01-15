package com.example.weatherapp.dataRemote.mappers

import com.example.weatherapp.data.model.EntityInfoHour
import com.example.weatherapp.dataRemote.models.WeatherListItem
import javax.inject.Inject

class MapperInfoHourEntity @Inject constructor() : MapperEntity<WeatherListItem, EntityInfoHour> {

    override fun mapFromModel(model: WeatherListItem): EntityInfoHour {
        return EntityInfoHour(
            hour = model.dt.toString(),
            temperature = model.main.temp
        )
    }

}