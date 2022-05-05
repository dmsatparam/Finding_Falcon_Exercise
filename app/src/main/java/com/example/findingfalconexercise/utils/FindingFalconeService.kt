package com.example.findingfalconexercise.utils

import com.example.findingfalconexercise.models.PlanetData
import com.example.findingfalconexercise.models.VehicleData
import retrofit2.Response
import retrofit2.http.GET

interface FindingFalconeService {
    @GET("planets")
    suspend fun getPlanets(): Response<List<PlanetData>?>

    @GET("planets")
    suspend fun getVehicles(): Response<List<VehicleData>?>
}