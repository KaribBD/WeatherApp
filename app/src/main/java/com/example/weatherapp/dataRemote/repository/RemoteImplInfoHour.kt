package com.example.weatherapp.dataRemote.repository

import com.example.weatherapp.data.model.EntityCoordinates
import com.example.weatherapp.data.model.EntityInfoHour
import com.example.weatherapp.data.repository.InfoHourRemote
import com.example.weatherapp.dataRemote.api.ServiceInfoHour
import com.example.weatherapp.dataRemote.mappers.MapperInfoHourEntity
import javax.inject.Inject

class RemoteImplInfoHour @Inject constructor(
    private val serviceInfoHour: ServiceInfoHour,
    private val mapperInfoHourEntity: MapperInfoHourEntity
) : InfoHourRemote {

    override suspend fun getInfoHours(coordinates: EntityCoordinates): List<EntityInfoHour> {
        val appId = "" //todo API KEY

        val response = serviceInfoHour.getInfoHour(
            coordinates.latitude,
            coordinates.longitude,
            appId
        )
        return response.list.map { modelInfoHour ->
            mapperInfoHourEntity.mapFromModel(modelInfoHour)
        }

    }

}