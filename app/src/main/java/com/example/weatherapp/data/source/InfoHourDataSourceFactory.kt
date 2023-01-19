package com.example.weatherapp.data.source

import com.example.weatherapp.data.repository.InfoHourDataSource
import javax.inject.Inject

class InfoHourDataSourceFactory @Inject constructor(
    private val infoHourDataSourceCache: InfoHourDataSourceCache,
    private val infoHourDataSourceRemote: InfoHourDataSourceRemote
) {

    open suspend fun getDataStore(): InfoHourDataSource {
        //todo  return cache

        return infoHourDataSourceRemote
    }
}