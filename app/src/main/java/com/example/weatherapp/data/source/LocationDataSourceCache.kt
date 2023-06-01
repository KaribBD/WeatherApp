package com.example.weatherapp.data.source

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.repository.LocationCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationDataSourceCache @Inject constructor(
    private val locationCache: LocationCache
) : LocationCache {

    override suspend fun getLocation(): Flow<CoordinatesEntity> {
        TODO("Not yet implemented")
    }

}