package com.example.weatherapp.data.source

import com.example.weatherapp.data.repository.WeatherDataSource
import javax.inject.Inject

class WeatherDataSourceFactory @Inject constructor(
    private val weatherDataSourceCache: WeatherDataSourceCache,
    private val weatherDataSourceRemote: WeatherDataSourceRemote
) {

    open suspend fun getDataStore(): WeatherDataSource {
        //todo  return cache

        return weatherDataSourceRemote
    }
}