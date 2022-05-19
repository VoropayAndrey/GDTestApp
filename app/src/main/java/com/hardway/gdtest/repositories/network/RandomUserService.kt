package com.hardway.gdtest.repositories.network

import com.hardway.gdtest.repositories.network.responses.GeneratedUserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RandomUserService {
    @GET("api/")
    suspend fun generateUser(): Response<GeneratedUserResponse>
}