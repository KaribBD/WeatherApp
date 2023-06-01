package com.example.weatherapp.data

import com.example.weatherapp.data.mapper.CoordinatesMapper
import com.example.weatherapp.data.source.LocationDataFactory
import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationDataFactory: LocationDataFactory,
    private val coordinatesMapper: CoordinatesMapper
) : LocationRepository {

    override suspend fun getLocation(): Flow<Coordinates> {
        val coordinatesFlow = locationDataFactory.getDataStore().getLocation()
            .map { entityCoordinates ->
                coordinatesMapper.mapFromEntity(entityCoordinates)
            }
        return coordinatesFlow
    }

}