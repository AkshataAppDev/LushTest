package com.lush.practicaltest.api

import com.lush.practicaltest.api.response.RocketDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("rockets")
    suspend fun getRocketList(): Response<ArrayList<RocketDataResponse.RocketDataResponseItem>>

}