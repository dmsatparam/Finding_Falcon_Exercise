package com.example.findingfalconexercise

import com.example.findingfalconexercise.models.PlanetData
import com.example.findingfalconexercise.models.VehicleData
import com.example.findingfalconexercise.request.RetrofitClient

class MainRepository {
    suspend fun getPlanets(): List<PlanetData>? {
        val request = RetrofitClient.apiClient.getPlanets()

        if(request.isSuccessful){
            return request.body()!!
        }
        return null
    }

    suspend fun getVehicles(): List<VehicleData>? {
        val request = RetrofitClient.apiClient.getVehicles()

        if(request.isSuccessful){
            return request.body()!!
        }
        return null
    }
}