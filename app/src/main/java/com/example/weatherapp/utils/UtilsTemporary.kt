package com.example.weatherapp.utils

import com.example.weatherapp.model.InfoDay
import com.example.weatherapp.model.InfoHour
import java.time.DayOfWeek

class UtilsTemporary {

    companion object {
        fun getWeatherListExample(): List<InfoHour> {
            return listOf(
                InfoHour("now",2),
                InfoHour("09.00",-2),
                InfoHour("10.00",4),
                InfoHour("10.00",4),
                InfoHour("11.00",8),
                InfoHour("12.00",-10),
                InfoHour("13.00",23),
                InfoHour("14.00",-25),
                InfoHour("15.00",29),
                InfoHour("16.00",2),
                InfoHour("17.00",0),
                InfoHour("18.00",0),
                InfoHour("19.00",0),
                InfoHour("20.00",0),
                InfoHour("21.00",0),
                InfoHour("22.00",0),
            )
        }

        fun getWeatherNextDaysListExample(): List<InfoDay> {
            return listOf(
                InfoDay("January 9", "Today", 1 , -10),
                InfoDay("January 10", "Tomorrow", 1 , -10),
                InfoDay("January 11", DayOfWeek.WEDNESDAY.name, 1 , -10),
                InfoDay("January 12", DayOfWeek.THURSDAY.name, 1 , -10),
                InfoDay("January 13", DayOfWeek.FRIDAY.name, 1 , -10),
                InfoDay("January 14", DayOfWeek.SATURDAY.name, 1 , -10),
                InfoDay("January 15", DayOfWeek.SUNDAY.name, 1 , -10),
                InfoDay("January 16", DayOfWeek.MONDAY.name, 1 , -10),
                InfoDay("January 17", DayOfWeek.THURSDAY.name, 1 , -10),
                InfoDay("January 18", DayOfWeek.THURSDAY.name, 1 , -10),
                InfoDay("January 19", DayOfWeek.THURSDAY.name, 1 , -10),
                InfoDay("January 20", DayOfWeek.THURSDAY.name, 1 , -10),
                InfoDay("January 21", DayOfWeek.THURSDAY.name, 1 , -10),
            )
        }
    }



}