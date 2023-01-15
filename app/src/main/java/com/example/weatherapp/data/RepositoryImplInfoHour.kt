package com.example.weatherapp.data

import com.example.weatherapp.data.mapper.InfoHourMapper
import com.example.weatherapp.data.source.DataSourceFactory
import com.example.weatherapp.domain.models.InfoHour
import com.example.weatherapp.domain.repository.RepositoryInfoHour
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImplInfoHour @Inject constructor(
    private val dataSourceFactory: DataSourceFactory,
    private val mapper: InfoHourMapper
) : RepositoryInfoHour {

    override suspend fun getWeatherHoursList(): Flow<List<InfoHour>> = flow {
        val infoHourList =
            dataSourceFactory.getDataStore().getInfoHours().map { infoHourEntity ->
                mapper.mapFromEntity(infoHourEntity)
            }
        emit(infoHourList)
    }

}