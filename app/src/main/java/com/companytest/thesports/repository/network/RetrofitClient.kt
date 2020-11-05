package com.companytest.thesports.repository.network

import com.companytest.thesports.repository.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        private lateinit var httpClient: OkHttpClient.Builder

        private lateinit var retrofit: Retrofit

        private lateinit var sportService: SportService

        fun getSportService(): SportService {
            val retrofitInterceptor: RetrofitInterceptor =
                RetrofitInterceptor()

            httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(retrofitInterceptor)
            httpClient.cache(null)

            retrofit =
                Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).client(
                    httpClient.build()
                )
                    .build()

            sportService = retrofit.create(
                SportService::class.java
            )
            return sportService
        }
    }
}