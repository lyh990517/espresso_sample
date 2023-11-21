package com.example.espresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.espresso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val input = binding.searchBar.text.toString()
            binding.searchResult.text = input
        }
    }
}