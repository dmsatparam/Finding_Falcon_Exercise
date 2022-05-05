package com.example.findingfalconexercise.request

import com.example.findingfalconexercise.utils.ApiClient
import com.example.findingfalconexercise.utils.ApiCredentials
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val RETROFITBUILDER = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiCredentials.BASE_URL)

    private var retrofit = RETROFITBUILDER.build()

    private var FindingFalconeService = retrofit.create(com.example.findingfalconexercise.utils.FindingFalconeService::class.java)

    val apiClient = ApiClient(FindingFalconeService)
}
