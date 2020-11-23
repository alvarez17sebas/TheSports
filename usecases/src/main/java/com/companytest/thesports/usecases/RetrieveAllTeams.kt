package com.companytest.thesports.usecases

import com.companytest.thesports.data.team.TeamRepositoryHandler
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveAllTeams @Inject constructor(private val teamRepositoryRepositoryHandler: TeamRepositoryHandler) {
    fun retrieveTeams(leagueParameter: String): Flow<ResultWrapper<List<Team>>> {
        return teamRepositoryRepositoryHandler.retrieveAll(leagueParameter)
    }
}