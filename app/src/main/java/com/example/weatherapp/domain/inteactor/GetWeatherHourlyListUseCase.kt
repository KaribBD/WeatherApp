package com.example.weatherapp.domain.inteactor

import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.models.HourWeather
import com.example.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetWeatherHourlyListUseCaseBase = BaseUseCase<Coordinates, Flow<List<HourWeather>>>


class GetWeatherHourlyListUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
) : GetWeatherHourlyListUseCaseBase  {

    override suspend fun invoke(params: Coordinates): Flow<List<HourWeather>> {
        return weatherRepository.getHourlyWeatherList(params)
    }

//    can be changed to:
//    override suspend operator fun invoke(params: Unit) = repositoryWeatherHour.getWeatherHoursList()

}