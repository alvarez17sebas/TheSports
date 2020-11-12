package com.companytest.thesports.usecases

import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.Team
import javax.inject.Inject

class RetrieveAllTeams @Inject constructor(private val teamRepositoryRepositoryHandler: TeamRepositoryHandler) {
    suspend fun retrieveTeams(leagueParameter: String): List<Team> {
        return teamRepositoryRepositoryHandler.retrieveAll(leagueParameter)
    }
}