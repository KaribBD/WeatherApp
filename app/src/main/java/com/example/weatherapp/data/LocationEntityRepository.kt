package com.example.weatherapp.data

import com.example.weatherapp.data.mapper.CoordinatesMapper
import com.example.weatherapp.data.source.LocationDataFactory
import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocationEntityRepository @Inject constructor(
    private val locationDataFactory: LocationDataFactory,
    private val mapper: CoordinatesMapper
) : LocationRepository {

    override suspend fun getLocation(): Flow<Coordinates>  {
        val coordinatesFlow = createNetworkData().getLocation().map { entityCoordinates ->
            mapper.mapFromEntity(entityCoordinates)
        }
        return coordinatesFlow
    }

    private fun createNetworkData() =
        locationDataFactory.createData(LocationDataFactory.SourceName.Network)

}