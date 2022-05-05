package com.example.findingfalconexercise.utils

import com.example.findingfalconexercise.models.PlanetData
import com.example.findingfalconexercise.models.VehicleData
import retrofit2.Response

class ApiClient (
    private val FindingFalconeService: FindingFalconeService
){
    suspend fun getPlanets(): Response<List<PlanetData>?>{
        return FindingFalconeService.getPlanets()
    }

    suspend fun getVehicles(): Response<List<VehicleData>?>{
        return FindingFalconeService.getVehicles()
    }
}
