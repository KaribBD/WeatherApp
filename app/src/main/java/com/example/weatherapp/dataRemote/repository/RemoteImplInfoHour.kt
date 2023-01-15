package com.example.weatherapp.dataRemote.repository

import com.example.weatherapp.data.model.EntityInfoHour
import com.example.weatherapp.data.repository.InfoHourRemote
import com.example.weatherapp.dataRemote.api.ServiceInfoHour
import com.example.weatherapp.dataRemote.mappers.MapperInfoHourEntity
import javax.inject.Inject

class RemoteImplInfoHour @Inject constructor(
    private val serviceInfoHour: ServiceInfoHour,
    private val mapperInfoHourEntity: MapperInfoHourEntity
) : InfoHourRemote {

    override suspend fun getInfoHours(): List<EntityInfoHour> {
        val lat = 44.34
        val lon = 10.99
        val appid = "" //todo API KEY

        val response = serviceInfoHour.getInfoHour(lat, lon, appid)
        return response.list.map { modelInfoHour ->
            mapperInfoHourEntity.mapFromModel(modelInfoHour)
        }

    }

}