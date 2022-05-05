package com.example.findingfalconexercise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.findingfalconexercise.R
import com.example.findingfalconexercise.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by lazy{
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.refreshPlanetsList()
        viewModel.planetsLiveData.observe(this){response ->
            if(response == null) {
                Toast.makeText(
                    this@MainActivity,
                    "Unsuccessful network call!",
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, response)
            spinner.adapter = adapter

        }
        //viewModel.vehiclesLiveData.observe(this)
    }
}