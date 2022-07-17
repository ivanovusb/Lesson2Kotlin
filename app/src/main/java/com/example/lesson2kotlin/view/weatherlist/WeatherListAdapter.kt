package com.example.lesson2kotlin.view.weatherlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2kotlin.MainActivity
import com.example.lesson2kotlin.R
import com.example.lesson2kotlin.databinding.FragmentWeatherListRecycleItemBinding
import com.example.lesson2kotlin.domain.Weather
import com.example.lesson2kotlin.view.details.DetailsFragment
import com.example.lesson2kotlin.view.details.OnItemClick

class WeatherListAdapter(private val dataList: List<Weather>, private val callback: OnItemClick) :
    RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding =
            FragmentWeatherListRecycleItemBinding.inflate(LayoutInflater.from(parent.context))
        return WeatherViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(weather: Weather) {
            val binding = FragmentWeatherListRecycleItemBinding.bind(itemView)
            binding.cityName.text = weather.city.name
            binding.root.setOnClickListener {
                callback.onItemClick(weather)
            }
        }
    }
}