package com.companytest.thesports.di

import com.companytest.thesports.datasource.network.BASE_URL
import com.companytest.thesports.datasource.network.RetrofitInterceptor
import com.companytest.thesports.datasource.network.SportService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient.Builder{
        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(RetrofitInterceptor())
        httpClient.cache(null)

        return httpClient
    }

    @Provides
    @Singleton
    fun provideRetrofit(httpClientBuilder: OkHttpClient.Builder): Retrofit {
        var retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(
                httpClientBuilder.build()
            )
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideSportService(retrofit: Retrofit): SportService {
        return retrofit.create(SportService::class.java)
    }

}