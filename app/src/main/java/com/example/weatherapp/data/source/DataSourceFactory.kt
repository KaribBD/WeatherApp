package com.example.weatherapp.data.source

import com.example.weatherapp.data.repository.InfoHourDataSource
import javax.inject.Inject

class DataSourceFactory @Inject constructor(
    private val dataSourceCacheInfoHour: DataSourceCacheInfoHour,
    private val dataSourceRemoteInfoHour: DataSourceRemoteInfoHour
) {

    open suspend fun getDataStore(): InfoHourDataSource {
        //todo  return cache

        return dataSourceRemoteInfoHour
    }
}