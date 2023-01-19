package com.example.weatherapp.dataRemote.repository

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.InfoHourEntity
import com.example.weatherapp.data.repository.InfoHourRemote
import com.example.weatherapp.dataRemote.api.InfoHourService
import com.example.weatherapp.dataRemote.mappers.InfoHourEntityMapper
import javax.inject.Inject

class InfoHourRemoteImpl @Inject constructor(
    private val infoHourService: InfoHourService,
    private val mapperInfoHourEntity: InfoHourEntityMapper
) : InfoHourRemote {

    override suspend fun getInfoHours(coordinates: CoordinatesEntity): List<InfoHourEntity> {
        val appId = "" //todo API KEY

        val response = infoHourService.getInfoHour(
            coordinates.latitude,
            coordinates.longitude,
            appId
        )
        return response.list.map { modelInfoHour ->
            mapperInfoHourEntity.mapFromModel(modelInfoHour)
        }

    }

}