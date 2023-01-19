package com.example.weatherapp.dataRemote.repository

import android.util.Log
import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.InfoHourEntity
import com.example.weatherapp.data.repository.InfoHourRemote
import com.example.weatherapp.dataRemote.api.InfoHourService
import com.example.weatherapp.dataRemote.api.Units
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
            appId,
            Units.CELSIUS.unit //todo get from Settings
        )

        Log.i("Response", response.toString())

        return response.list.map { modelInfoHour ->
            mapperInfoHourEntity.mapFromModel(modelInfoHour)
        }

    }

}