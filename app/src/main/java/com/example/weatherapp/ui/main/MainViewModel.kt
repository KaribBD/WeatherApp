package com.example.weatherapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.InfoDay
import com.example.weatherapp.model.InfoHour
import com.example.weatherapp.utils.UtilsTemporary

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _listInfoHour: MutableLiveData<List<InfoHour>> = MutableLiveData()
    val listInfoHour: LiveData<List<InfoHour>> = _listInfoHour
    private val _listNextDays: MutableLiveData<List<InfoDay>> = MutableLiveData()
    val listNextDays: LiveData<List<InfoDay>> = _listNextDays


    fun getListInfoHour() {
        _listInfoHour.value = UtilsTemporary.getWeatherListExample()
    }

    fun getListNextDays() {
        _listNextDays.value = UtilsTemporary.getWeatherNextDaysListExample()
    }

}