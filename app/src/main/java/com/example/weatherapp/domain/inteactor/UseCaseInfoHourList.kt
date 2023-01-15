package com.example.weatherapp.domain.inteactor

import com.example.weatherapp.domain.models.InfoHour
import com.example.weatherapp.domain.repository.RepositoryInfoHour
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias UseCaseGetInfoHourListBase = BaseUseCase<Unit, Flow<List<InfoHour>>>


class UseCaseGetInfoHourList @Inject constructor(
    private val repositoryInfoHour: RepositoryInfoHour
) : UseCaseGetInfoHourListBase  {

    override suspend fun invoke(params: Unit): Flow<List<InfoHour>> {
        return repositoryInfoHour.getWeatherHoursList()
    }

//    can be changed to:
//    override suspend operator fun invoke(params: Unit) = repositoryWeatherHour.getWeatherHoursList()

}