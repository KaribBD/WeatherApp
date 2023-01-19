package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.domain.models.Coordinates
import javax.inject.Inject

class CoordinatesMapper @Inject constructor() : Mapper<CoordinatesEntity, Coordinates> {

    override fun mapFromEntity(type: CoordinatesEntity): Coordinates {
        return Coordinates(
            latitude = type.latitude,
            longitude = type.longitude
        )
    }

    override fun mapToEntity(type: Coordinates): CoordinatesEntity {
        return CoordinatesEntity(
            latitude = type.latitude,
            longitude = type.longitude
        )
    }

}