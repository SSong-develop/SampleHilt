package com.example.samplehilt.di.module

import com.example.samplehilt.data.api.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class MainApplicationModule {

    @Provides
    fun provideBaseUrl() = "https://5e510330f2c0d300147c034c.mockapi.io/"

    @Provides
    @Singleton
    fun provideRetrofit(
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRetrofitService(retrofit: Retrofit): RetrofitService =
        retrofit.create(RetrofitService::class.java)

}