package com.example.weatherapp.data

import com.example.weatherapp.data.mapper.CoordinatesMapper
import com.example.weatherapp.data.mapper.InfoHourMapper
import com.example.weatherapp.data.source.InfoHourDataSourceFactory
import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.models.InfoHour
import com.example.weatherapp.domain.repository.InfoHourRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InfoHourRepositoryImpl @Inject constructor(
    private val infoHourDataSourceFactory: InfoHourDataSourceFactory,
    private val infoHourMapper: InfoHourMapper,
    private val coordinatesMapper: CoordinatesMapper
) : InfoHourRepository {

    override suspend fun getWeatherHoursList(coordinates: Coordinates): Flow<List<InfoHour>> = flow {
        val entityCoordinates = coordinatesMapper.mapToEntity(coordinates)

        val infoHourList =
            infoHourDataSourceFactory.getDataStore().getInfoHours(entityCoordinates).map { infoHourEntity ->
                infoHourMapper.mapFromEntity(infoHourEntity)
            }
        emit(infoHourList)
    }

}