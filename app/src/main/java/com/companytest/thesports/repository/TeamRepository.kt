package com.companytest.thesports.repository

import com.companytest.thesports.data.Repository
import com.companytest.thesports.domain.Team
import com.companytest.thesports.repository.network.RetrofitClient
import com.companytest.thesports.repository.network.SportService
import javax.inject.Inject

class TeamRepository @Inject constructor() :
    Repository<Team> {

    private var sportService: SportService =
        RetrofitClient.getSportService()

    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return sportService.retrieveAllTeams(leagueParameter).teams
    }

    override suspend fun retrieveById(teamId: String): List<Team> {
        return sportService.retrieveTeam(teamId).teams
    }

}