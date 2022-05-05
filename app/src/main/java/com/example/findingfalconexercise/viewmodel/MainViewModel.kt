package com.example.findingfalconexercise.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findingfalconexercise.MainRepository
import com.example.findingfalconexercise.models.PlanetData
import com.example.findingfalconexercise.models.VehicleData
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    private val _planetsLiveData = MutableLiveData<List<String>?>()
    private val _vehiclesLiveData = MutableLiveData<List<String>?>()

    private var planets =  listOf<PlanetData>()
    private var vehicles =  listOf<VehicleData>()

    val planetsLiveData: LiveData<List<String>?> = _planetsLiveData
    val vehiclesLiveData: LiveData<List<String>?> = _vehiclesLiveData


    fun refreshPlanetsList(){
        viewModelScope.launch {
            planets = repository.getPlanets()!!
            val response = arrayListOf<String>()
            for(planet in planets){
                response.add(planet.name)
            }
            _planetsLiveData.postValue(response)
        }
    }

    fun refreshVehiclesList(){
        viewModelScope.launch {
            vehicles = repository.getVehicles()!!
            val response = arrayListOf<String>()
            for(planet in vehicles){
                response.add(planet.name)
            }
            _vehiclesLiveData.postValue(response)
        }
    }
}