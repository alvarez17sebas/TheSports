package com.companytest.thesports.repository.real

import com.companytest.thesports.model.Team
import com.companytest.thesports.repository.RemoteRepository
import javax.inject.Inject

class TeamRepository @Inject constructor() :
    RemoteRepository<Team> {

    private var sportService: SportService =
        RetrofitClient.getSportService()


    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return sportService.retrieveAllTeams(leagueParameter).teams
    }

    override suspend fun retrieveById(teamId: String): List<Team> {
        return sportService.retrieveTeam(teamId).teams
    }

}