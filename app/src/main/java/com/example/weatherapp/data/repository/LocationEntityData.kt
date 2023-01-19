package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.CoordinatesEntity
import kotlinx.coroutines.flow.Flow

interface LocationEntityData {
    suspend fun getLocation(): Flow<CoordinatesEntity>
    suspend fun saveLocation(coordinates: CoordinatesEntity) { /* default implementation */ }
}