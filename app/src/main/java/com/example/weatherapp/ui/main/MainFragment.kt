package com.example.weatherapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.utils.UtilsTemporary

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getListInfoHour()
        viewModel.getListNextDays()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.todayTempValue.text = "+3"
        binding.todayWeatherDescription.text = getString(R.string.weather_light_rain)
        binding.todayFeelsLike.text = getString(R.string.fells_like, "+", 1)
        binding.nextDayForecastTextView.text = getString(R.string.n_day_forecast, 10)

        val adapterWeatherHours =
            RecyclerViewAdapterWeatherHours(viewModel.listInfoHour.value!!) //todo !!
        binding.todayHoursWeatherRecyclerView.adapter = adapterWeatherHours

        val adapterWeatherNextDays =
            RecyclerViewAdapterWeatherNextDays(viewModel.listNextDays.value!!) //todo !!
        binding.nextDaysListRecyclerView.layoutManager = LinearLayoutManager(view.context)
        binding.nextDaysListRecyclerView.adapter = adapterWeatherNextDays

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}