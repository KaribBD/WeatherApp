package com.example.weatherapp.data.source

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.repository.LocationRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationDataSourceRemote @Inject constructor(
    private val locationRemote: LocationRemote
): LocationRemote {

    override suspend fun getLocation(): Flow<CoordinatesEntity> {
        return  locationRemote.getLocation()
    }

}