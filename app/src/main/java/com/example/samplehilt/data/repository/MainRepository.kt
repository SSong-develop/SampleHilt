package com.example.samplehilt.data.repository

import com.example.samplehilt.data.api.RetrofitService
import javax.inject.Inject

class MainRepository @Inject constructor(private val retrofitService: RetrofitService) {

    suspend fun getUsers() = retrofitService.getUsers()
}