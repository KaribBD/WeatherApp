package com.example.weatherapp.data.source

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.InfoHourEntity
import com.example.weatherapp.data.repository.InfoHourRemote
import javax.inject.Inject

class InfoHourDataSourceRemote @Inject constructor(
    private val remoteInfoHourRemote: InfoHourRemote
) : InfoHourRemote {

    override suspend fun getInfoHours(coordinates: CoordinatesEntity): List<InfoHourEntity> {
        return remoteInfoHourRemote.getInfoHours(coordinates)
    }


}