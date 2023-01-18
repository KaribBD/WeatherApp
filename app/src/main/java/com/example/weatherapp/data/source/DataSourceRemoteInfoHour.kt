package com.example.weatherapp.data.source

import com.example.weatherapp.data.model.EntityCoordinates
import com.example.weatherapp.data.model.EntityInfoHour
import com.example.weatherapp.data.repository.InfoHourRemote
import javax.inject.Inject

class DataSourceRemoteInfoHour @Inject constructor(
    private val remoteInfoHourRemote: InfoHourRemote
) : InfoHourRemote {

    override suspend fun getInfoHours(coordinates: EntityCoordinates): List<EntityInfoHour> {
        return remoteInfoHourRemote.getInfoHours(coordinates)
    }


}