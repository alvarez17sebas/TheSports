package com.companytest.thesports.data

import com.companytest.thesports.data.network.TheSportService
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.Repository
import javax.inject.Inject

class TeamRepository @Inject constructor(var sportService: TheSportService) :
    Repository<Team> {

    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return sportService.retrieveAllTeams(leagueParameter).teams
    }

    override suspend fun retrieveById(teamId: String): List<Team> {
        return sportService.retrieveTeam(teamId).teams
    }

}