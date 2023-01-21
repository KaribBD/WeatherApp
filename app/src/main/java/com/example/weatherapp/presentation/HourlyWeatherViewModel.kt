package com.example.weatherapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.inteactor.GetLocationUpdatesUseCase
import com.example.weatherapp.domain.models.HourWeather
import com.example.weatherapp.domain.inteactor.GetWeatherHourlyListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class HourlyWeatherUIModel {
    object Loading : HourlyWeatherUIModel()
    data class Error(var error: String = "") : HourlyWeatherUIModel()
    data class Success(val data: List<HourWeather>) : HourlyWeatherUIModel()
}

@HiltViewModel
class HourlyWeatherViewModel @Inject constructor(
    private val getWeatherHourlyListUseCase: GetWeatherHourlyListUseCase,
    private val getLocationUpdatesUseCase: GetLocationUpdatesUseCase
) : ViewModel() {

    //view model param

    private val _hourlyWeatherList = MutableLiveData<HourlyWeatherUIModel>()
    private var hourlyWeatherList: LiveData<HourlyWeatherUIModel> = _hourlyWeatherList


    fun getHourlyWeatherList(): LiveData<HourlyWeatherUIModel> {
        return hourlyWeatherList
    }

    //coroutines

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _hourlyWeatherList.postValue(HourlyWeatherUIModel.Error(exception.message ?: "Error"))
    }

    fun startLoadHourlyWeather() {
        viewModelScope.launch(Job() + Dispatchers.IO + coroutineExceptionHandler) {
            loadDailyWeatherList()
        }
    }

    //functions

    private suspend fun loadDailyWeatherList() {

        getLocationUpdatesUseCase(Unit).collect { coordinates ->

            Log.i("coordinates", "$coordinates")
            getWeatherHourlyListUseCase(coordinates).collect {
                _hourlyWeatherList.postValue(HourlyWeatherUIModel.Success(it))
            }
        }
    }


}