package com.example.weatherapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.inteactor.GetLocationUpdatesUseCase
import com.example.weatherapp.domain.inteactor.GetWeatherDailyListUseCase
import com.example.weatherapp.domain.models.DayWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class DailyWeatherUIModel {
    object Loading : DailyWeatherUIModel()
    data class Error(var error: String = "") : DailyWeatherUIModel()
    data class Success(val data: List<DayWeather>) : DailyWeatherUIModel()
}

@HiltViewModel
class DailyWeatherViewModel @Inject constructor(
    private val getWeatherDailyListUseCase: GetWeatherDailyListUseCase,
    private val getLocationUpdatesUseCase: GetLocationUpdatesUseCase
) : ViewModel() {

    //view model param

    private val _dailyWeatherList = MutableLiveData<DailyWeatherUIModel>()
    private var dailyWeatherList: LiveData<DailyWeatherUIModel> = _dailyWeatherList

    fun getDailyWeatherList(): LiveData<DailyWeatherUIModel> {
        return dailyWeatherList
    }

    //coroutines

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.i("WeatherException", "exception, $exception")
        _dailyWeatherList.postValue(DailyWeatherUIModel.Error(exception.message ?: "Error"))
    }

    fun startLoadDailyWeather() {
        viewModelScope.launch(Job() + Dispatchers.IO + coroutineExceptionHandler) {
            loadDailyWeatherList()
        }
    }

    //functions

    private suspend fun loadDailyWeatherList() {

        getLocationUpdatesUseCase(Unit).collect { coordinates ->

            Log.i("coordinates", "$coordinates")
            getWeatherDailyListUseCase(coordinates).collect {
                _dailyWeatherList.postValue(DailyWeatherUIModel.Success(it))
            }
        }
    }

}