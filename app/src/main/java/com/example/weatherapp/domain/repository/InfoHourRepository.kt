package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.models.InfoHour
import kotlinx.coroutines.flow.Flow

interface InfoHourRepository {
    //Remote
    suspend fun getWeatherHoursList(coordinates: Coordinates): Flow<List<InfoHour>>
}