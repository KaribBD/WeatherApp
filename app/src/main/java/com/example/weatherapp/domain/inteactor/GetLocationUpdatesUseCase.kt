package com.example.weatherapp.domain.inteactor

import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias UseCaseGetLocationBase = BaseUseCase<Unit, Flow<Coordinates>>


class GetLocationUpdatesUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) : UseCaseGetLocationBase {

    override suspend fun invoke(params: Unit): Flow<Coordinates> {
        return locationRepository.getLocation()
    }

}