package com.companytest.thesports.repository

import com.companytest.thesports.model.Team
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class TeamRepository @Inject constructor() : RemoteRepository<Team> {

    private var retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    private var sportService: SportService = retrofit.create(SportService::class.java)

    override suspend fun retrieveAll(): List<Team> {
        return sportService.retrieveAllTeams().teams
    }

    override suspend fun retrieveById(teamId: String): Team {
        return sportService.retrieveTeam(teamId)
    }
}