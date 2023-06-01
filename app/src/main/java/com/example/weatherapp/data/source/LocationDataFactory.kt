package com.example.weatherapp.data.source

import com.example.weatherapp.data.repository.LocationDataSource
import javax.inject.Inject

class LocationDataFactory @Inject constructor(
    private val locationEntityDataCache: LocationDataSourceCache,
    private val locationEntityDataRemote: LocationDataSourceRemote
) {

    suspend fun getDataStore(): LocationDataSource {
        return locationEntityDataRemote
    }

}