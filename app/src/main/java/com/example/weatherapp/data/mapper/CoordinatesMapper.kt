package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.model.EntityCoordinates
import com.example.weatherapp.domain.models.Coordinates
import javax.inject.Inject

class CoordinatesMapper @Inject constructor() : Mapper<EntityCoordinates, Coordinates> {

    override fun mapFromEntity(type: EntityCoordinates): Coordinates {
        return Coordinates(
            latitude = type.latitude,
            longitude = type.longitude
        )
    }

    override fun mapToEntity(type: Coordinates): EntityCoordinates {
        return EntityCoordinates(
            latitude = type.latitude,
            longitude = type.longitude
        )
    }

}