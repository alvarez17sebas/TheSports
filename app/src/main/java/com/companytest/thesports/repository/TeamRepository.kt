package com.companytest.thesports.repository

import com.companytest.thesports.model.Team
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class TeamRepository @Inject constructor() : RemoteRepository<Team> {


    private var sportService: SportService = RetrofitClient.getSportService()


    override suspend fun retrieveAll(): List<Team> {
        return sportService.retrieveAllTeams().teams
    }

    override suspend fun retrieveById(teamId: String): List<Team> {
        return sportService.retrieveTeam(teamId).teams
    }

}