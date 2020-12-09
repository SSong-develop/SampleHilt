package com.example.samplehilt.data.api

import com.example.samplehilt.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("users")
    suspend fun getUsers() : Response<List<User>>
}