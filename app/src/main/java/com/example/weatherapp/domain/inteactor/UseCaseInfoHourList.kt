package com.example.weatherapp.domain.inteactor

import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.models.InfoHour
import com.example.weatherapp.domain.repository.RepositoryInfoHour
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias UseCaseGetInfoHourListBase = BaseUseCase<Coordinates, Flow<List<InfoHour>>>


class UseCaseGetInfoHourList @Inject constructor(
    private val repositoryInfoHour: RepositoryInfoHour,
) : UseCaseGetInfoHourListBase  {

    override suspend fun invoke(params: Coordinates): Flow<List<InfoHour>> {
        return repositoryInfoHour.getWeatherHoursList(params)
    }

//    can be changed to:
//    override suspend operator fun invoke(params: Unit) = repositoryWeatherHour.getWeatherHoursList()

}