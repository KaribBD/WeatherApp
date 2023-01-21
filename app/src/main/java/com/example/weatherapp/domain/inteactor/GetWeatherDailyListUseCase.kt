package com.example.weatherapp.domain.inteactor

import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.models.DayWeather
import com.example.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetWeatherDailyListUseCaseBase = BaseUseCase<Coordinates, Flow<List<DayWeather>>>


class GetWeatherDailyListUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
) : GetWeatherDailyListUseCaseBase {

    override suspend fun invoke(params: Coordinates): Flow<List<DayWeather>> {
        return weatherRepository.getDailyWeatherList(params)
    }

}