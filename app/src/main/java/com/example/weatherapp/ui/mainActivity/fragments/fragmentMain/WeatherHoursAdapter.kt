package com.example.weatherapp.ui.mainActivity.fragments.fragmentMain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemHourWeatherBinding
import com.example.weatherapp.domain.models.HourWeather

class WeatherHoursAdapter :
    RecyclerView.Adapter<WeatherHoursAdapter.ViewHolderItemHour>() {

    private val diffCallback = object : DiffUtil.ItemCallback<HourWeather>() {
        override fun areItemsTheSame(oldItem: HourWeather, newItem: HourWeather): Boolean {
            return oldItem.hour == newItem.hour
        }

        override fun areContentsTheSame(oldItem: HourWeather, newItem: HourWeather): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    /////////////////////////////////////////

    var dataList: List<HourWeather>
        get() = differ.currentList
        set(value) = differ.submitList(value)

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

        fun bind(hourWeather: HourWeather) {
            binding.itemHourTime.text = hourWeather.hour
            binding.itemHourTemperature.text = hourWeather.temperature.toString()
        }
    }

}