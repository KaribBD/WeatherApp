package com.example.weatherapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemHourWeatherBinding
import com.example.weatherapp.model.InfoHour

class RecyclerViewAdapterWeatherHours(var dataList: List<InfoHour>) :
    RecyclerView.Adapter<RecyclerViewAdapterWeatherHours.ViewHolderItemHour>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemHour {
        val binding = ItemHourWeatherBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderItemHour(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderItemHour, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    class ViewHolderItemHour(private val binding: ItemHourWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(infoHour: InfoHour) {
            binding.itemHourTime.text = infoHour.hour
            binding.itemHourTemperature.text = infoHour.temperature.toString()

        }
    }

}