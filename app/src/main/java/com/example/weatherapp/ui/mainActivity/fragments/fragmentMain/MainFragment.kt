package com.example.weatherapp.ui.mainActivity.fragments.fragmentMain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.presentation.DailyWeatherUIModel
import com.example.weatherapp.presentation.DailyWeatherViewModel
import com.example.weatherapp.presentation.HourlyWeatherUIModel
import com.example.weatherapp.presentation.HourlyWeatherViewModel
import com.example.weatherapp.ui.core.dialog.dismissLoadingDialog
import com.example.weatherapp.ui.core.dialog.showLoadingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HourlyWeatherViewModel
    private lateinit var dailyViewModel: DailyWeatherViewModel
    private lateinit var weatherHoursAdapter: WeatherHoursAdapter
    private lateinit var weatherDaysAdapter: WeatherDaysAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HourlyWeatherViewModel::class.java]
        dailyViewModel = ViewModelProvider(this)[DailyWeatherViewModel::class.java]
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

        weatherHoursAdapter = WeatherHoursAdapter()
        binding.todayHoursWeatherRecyclerView.adapter = weatherHoursAdapter

        weatherDaysAdapter = WeatherDaysAdapter()
        binding.nextDaysListRecyclerView.layoutManager = LinearLayoutManager(view.context)
        binding.nextDaysListRecyclerView.adapter = weatherDaysAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.startLoadHourlyWeather()
        viewModel.getHourlyWeatherList().observe(viewLifecycleOwner, ::onViewStateChange)

        dailyViewModel.startLoadDailyWeather()
        dailyViewModel.getDailyWeatherList().observe(viewLifecycleOwner, ::onDailyWeatherViewStateChange)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    ////////////////////////////////////////////////////////

    private fun onViewStateChange(event: HourlyWeatherUIModel) {
        when (event) {
            is HourlyWeatherUIModel.Error -> handleErrorMessage(event.error)
            is HourlyWeatherUIModel.Loading -> handleLoading(true)
            is HourlyWeatherUIModel.Success -> handleSuccess(event)
        }
    }

    private fun handleLoading(isLoading: Boolean) {
        if (isLoading) showLoadingDialog() else dismissLoadingDialog()
    }

    private fun handleErrorMessage(message: String?) {
        if (message.isNullOrBlank()) return
        dismissLoadingDialog()
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun handleSuccess(event: HourlyWeatherUIModel.Success) {
        handleLoading(false)
        event.data.let {
            weatherHoursAdapter.dataList = it
        }
    }

    ////////////////////////////////////////////////////

    private fun onDailyWeatherViewStateChange(event: DailyWeatherUIModel) {
        when (event) {
            is DailyWeatherUIModel.Error -> handleDailyWeatherErrorMessage(event.error)
            is DailyWeatherUIModel.Loading -> handleDailyWeatherLoading(true)
            is DailyWeatherUIModel.Success -> handleDailyWeatherSuccess(event)
        }
    }

    private fun handleDailyWeatherLoading(isLoading: Boolean) {
        if (isLoading) showLoadingDialog() else dismissLoadingDialog()
    }

    private fun handleDailyWeatherErrorMessage(message: String?) {
        if (message.isNullOrBlank()) return
        dismissLoadingDialog()
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun handleDailyWeatherSuccess(event: DailyWeatherUIModel.Success) {
        handleDailyWeatherLoading(false)
        event.data.let {
            weatherDaysAdapter.dataList = it
        }
    }

}