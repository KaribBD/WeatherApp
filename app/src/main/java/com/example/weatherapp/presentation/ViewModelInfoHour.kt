package com.example.weatherapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.inteactor.GetLocationUpdatesUseCase
import com.example.weatherapp.domain.models.InfoHour
import com.example.weatherapp.domain.inteactor.UseCaseGetInfoHourList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class InfoHourUIModel {
    object Loading : InfoHourUIModel()
    data class Error(var error: String = "") : InfoHourUIModel()
    data class Success(val data: List<InfoHour>) : InfoHourUIModel()
}

@HiltViewModel
class ViewModelInfoHour @Inject constructor(
    private val infoHourGetListUseCase: UseCaseGetInfoHourList,
    private val getLocationUpdatesUseCase: GetLocationUpdatesUseCase
) : ViewModel() {

    private val _listInfoHour = MutableLiveData<InfoHourUIModel>()
    private var listInfoHour: LiveData<InfoHourUIModel> = _listInfoHour


    fun getListInfoHour(): LiveData<InfoHourUIModel> {
       return listInfoHour
    }

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _listInfoHour.postValue(InfoHourUIModel.Error(exception.message ?: "Error"))
    }

    fun startLoadListInfoHour() {
        viewModelScope.launch (Job() + Dispatchers.IO + coroutineExceptionHandler) {
            loadListInfoHour()
        }
    }

    private suspend fun loadListInfoHour() {

        getLocationUpdatesUseCase(Unit).collect { coordinates ->

            Log.i("coordinates", "coordinates = $coordinates}")

            infoHourGetListUseCase(coordinates).collect { //todo real coordinates
                _listInfoHour.postValue(InfoHourUIModel.Success(it))
            }
        }

    }


}