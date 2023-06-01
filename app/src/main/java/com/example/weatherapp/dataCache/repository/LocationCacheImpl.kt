package com.example.weatherapp.dataCache.repository

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.repository.LocationCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationCacheImpl @Inject constructor() : LocationCache {

    override suspend fun getLocation(): Flow<CoordinatesEntity> {
        TODO("Not yet implemented")
    }

}