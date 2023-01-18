package com.example.weatherapp.data.source

import com.example.weatherapp.data.model.EntityCoordinates
import com.example.weatherapp.data.model.EntityInfoHour
import com.example.weatherapp.data.repository.InfoHourCache
import javax.inject.Inject

class DataSourceCacheInfoHour @Inject constructor(
    infoHourCache: InfoHourCache
) : InfoHourCache {

    override suspend fun getInfoHours(coordinates: EntityCoordinates): List<EntityInfoHour> {
        TODO("Not yet implemented")
    }

}