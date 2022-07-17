package com.example.lesson2kotlin.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lesson2kotlin.MainActivity
import com.example.lesson2kotlin.R
import com.example.lesson2kotlin.databinding.FragmentWeatherListBinding
import com.example.lesson2kotlin.domain.Weather
import com.example.lesson2kotlin.view.details.DetailsFragment
import com.example.lesson2kotlin.view.details.OnItemClick
import com.example.lesson2kotlin.viewmodel.AppState
import com.example.lesson2kotlin.viewmodel.WeatherListViewModel

class WeatherListFragment : Fragment(), OnItemClick {

    companion object {
        fun newInstance() = WeatherListFragment()
    }

    var isRussian = true

    private var _binding: FragmentWeatherListBinding?= null
    private val binding: FragmentWeatherListBinding
    get() {
        return _binding!!
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    lateinit var viewModel: WeatherListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, object : Observer<AppState> {
            override fun onChanged(t: AppState) {
                renderData(t)
            }
        })

        binding.weatherListFragmentFAB.setOnClickListener{
            isRussian = !isRussian
            if (isRussian) {
                viewModel.getWeatherListForRussia()
                binding.weatherListFragmentFAB.setImageResource(R.drawable.ic_baseline_home_24)
            } else {
                viewModel.getWeatherListForWorld()
                binding.weatherListFragmentFAB.setImageResource(R.drawable.ic_baseline_flight_24)
            }
        }
        viewModel.getWeatherListForRussia()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {/*TODO() HW*/
            }
            AppState.Loading -> {/*TODO() HW*/
            }
            is AppState.SuccessSingle -> {
                val result = appState.weatherData

            }
            is AppState.SuccessGlobal -> {
                binding.weatherListFragmentRecyclerView.adapter = WeatherListAdapter(appState.weatherList, this)
            }
        }
    }

    override fun onItemClick(weather: Weather) {
        requireActivity().supportFragmentManager.beginTransaction().hide(this)
            .add(
                R.id.container, DetailsFragment.newInstance(weather)
            ).addToBackStack("").commit()
    }
}