package com.example.weatherapp.dataCache.repository

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.InfoHourEntity
import com.example.weatherapp.data.repository.InfoHourCache
import javax.inject.Inject

class InfoHourCacheImpl @Inject constructor() : InfoHourCache {

    override suspend fun getInfoHours(coordinates: CoordinatesEntity): List<InfoHourEntity> {
        TODO("Not yet implemented")
    }
}