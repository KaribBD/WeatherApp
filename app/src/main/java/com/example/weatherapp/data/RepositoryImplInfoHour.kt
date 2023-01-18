package com.example.weatherapp.data

import com.example.weatherapp.data.mapper.CoordinatesMapper
import com.example.weatherapp.data.mapper.InfoHourMapper
import com.example.weatherapp.data.source.DataSourceFactory
import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.models.InfoHour
import com.example.weatherapp.domain.repository.RepositoryInfoHour
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImplInfoHour @Inject constructor(
    private val dataSourceFactory: DataSourceFactory,
    private val infoHourMapper: InfoHourMapper,
    private val coordinatesMapper: CoordinatesMapper
) : RepositoryInfoHour {

    override suspend fun getWeatherHoursList(coordinates: Coordinates): Flow<List<InfoHour>> = flow {
        val entityCoordinates = coordinatesMapper.mapToEntity(coordinates)

        val infoHourList =
            dataSourceFactory.getDataStore().getInfoHours(entityCoordinates).map { infoHourEntity ->
                infoHourMapper.mapFromEntity(infoHourEntity)
            }
        emit(infoHourList)
    }

}