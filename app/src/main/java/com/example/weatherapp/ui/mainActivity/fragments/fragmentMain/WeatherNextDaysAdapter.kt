package com.example.weatherapp.ui.mainActivity.fragments.fragmentMain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemNextDaysWeatherBinding
import com.example.weatherapp.domain.models.InfoDay

class WeatherNextDaysAdapter(val listNextDays: List<InfoDay>) :
    RecyclerView.Adapter<WeatherNextDaysAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNextDaysWeatherBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNextDays[position])
    }

    override fun getItemCount(): Int {
        return listNextDays.size
    }


    class ViewHolder(private val binding: ItemNextDaysWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(infoDay: InfoDay) {
            binding.itemNextDaysDate.text = infoDay.date
            binding.itemNextDaysDayOfWeek.text = infoDay.dayOfWeek
            binding.itemNextDaysDayValue.text = infoDay.dayTemperature.toString()
            binding.itemNextDaysNightValue.text = infoDay.nightTemperature.toString()
        }

    }

}