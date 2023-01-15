package com.example.weatherapp.ui.mainActivity.fragments.fragmentMain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.presentation.InfoHourUIModel
import com.example.weatherapp.presentation.ViewModelInfoHour
import com.example.weatherapp.ui.core.dialog.dismissLoadingDialog
import com.example.weatherapp.ui.core.dialog.showLoadingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMain : Fragment() {

    companion object {
        fun newInstance() = FragmentMain()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ViewModelInfoHour
    private lateinit var adapterWeatherHours: RecyclerViewAdapterWeatherHours

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewModelInfoHour::class.java]
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

        adapterWeatherHours = RecyclerViewAdapterWeatherHours()
        binding.todayHoursWeatherRecyclerView.adapter = adapterWeatherHours

        //val adapterWeatherNextDays =
        //    RecyclerViewAdapterWeatherNextDays(viewModel.listNextDays.value!!) //todo !!
        //binding.nextDaysListRecyclerView.layoutManager = LinearLayoutManager(view.context)
        //binding.nextDaysListRecyclerView.adapter = adapterWeatherNextDays

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.startLoadListInfoHour()
        viewModel.getListInfoHour().observe(viewLifecycleOwner, ::onViewStateChange)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onViewStateChange(event: InfoHourUIModel) {
        when (event) {
            is InfoHourUIModel.Error -> handleErrorMessage(event.error)
            is InfoHourUIModel.Loading -> handleLoading(true)
            is InfoHourUIModel.Success -> handleSuccess(event)
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

    private fun handleSuccess(event: InfoHourUIModel.Success) {
        handleLoading(false)
        event.data.let {
            adapterWeatherHours.dataList = it
        }
    }

}