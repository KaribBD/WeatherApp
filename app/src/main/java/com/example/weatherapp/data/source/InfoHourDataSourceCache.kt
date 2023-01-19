package com.example.weatherapp.data.source

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.InfoHourEntity
import com.example.weatherapp.data.repository.InfoHourCache
import javax.inject.Inject

class InfoHourDataSourceCache @Inject constructor(
    infoHourCache: InfoHourCache
) : InfoHourCache {

    override suspend fun getInfoHours(coordinates: CoordinatesEntity): List<InfoHourEntity> {
        TODO("Not yet implemented")
    }

}