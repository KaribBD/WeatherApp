package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.EntityCoordinates
import kotlinx.coroutines.flow.Flow

interface LocationEntityData {
    suspend fun getLocation(): Flow<EntityCoordinates>
    suspend fun saveLocation(coordinates: EntityCoordinates) { /* default implementation */ }
}