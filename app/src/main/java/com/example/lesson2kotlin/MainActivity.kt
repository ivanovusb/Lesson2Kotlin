package com.example.lesson2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.lesson2kotlin.Lesson3.Lesson3
import com.example.lesson2kotlin.databinding.ActivityMainBinding
import com.example.lesson2kotlin.view.weatherlist.WeatherListFragment

class MainActivity : AppCompatActivity() {



    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.myRoot)


        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, WeatherListFragment.newInstance())
                .commit()
        }

        Lesson3.startLessonCollections()
    }

}

