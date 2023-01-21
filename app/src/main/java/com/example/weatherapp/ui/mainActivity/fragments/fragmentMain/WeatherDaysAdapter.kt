package com.example.weatherapp.ui.mainActivity.fragments.fragmentMain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemNextDaysWeatherBinding
import com.example.weatherapp.domain.models.DayWeather
import com.example.weatherapp.domain.models.HourWeather

class WeatherDaysAdapter :
    RecyclerView.Adapter<WeatherDaysAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<DayWeather>() {
        override fun areItemsTheSame(oldItem: DayWeather, newItem: DayWeather): Boolean {
            return oldItem.time == newItem.time
        }

        override fun areContentsTheSame(oldItem: DayWeather, newItem: DayWeather): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    ///////////////////////////

    var dataList: List<DayWeather>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNextDaysWeatherBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    class ViewHolder(private val binding: ItemNextDaysWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dayWeather: DayWeather) {
            binding.itemNextDaysDate.text = dayWeather.time
            binding.itemNextDaysDayOfWeek.text = dayWeather.time
            binding.itemNextDaysDayValue.text = dayWeather.temperature_max.toString()
            binding.itemNextDaysNightValue.text = dayWeather.temperature_min.toString()
        }

    }

}