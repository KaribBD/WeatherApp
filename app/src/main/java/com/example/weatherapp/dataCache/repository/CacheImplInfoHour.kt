package com.example.weatherapp.dataCache.repository

import com.example.weatherapp.data.model.EntityCoordinates
import com.example.weatherapp.data.model.EntityInfoHour
import com.example.weatherapp.data.repository.InfoHourCache
import javax.inject.Inject

class CacheImplInfoHour @Inject constructor() : InfoHourCache {

    override suspend fun getInfoHours(coordinates: EntityCoordinates): List<EntityInfoHour> {
        TODO("Not yet implemented")
    }
}