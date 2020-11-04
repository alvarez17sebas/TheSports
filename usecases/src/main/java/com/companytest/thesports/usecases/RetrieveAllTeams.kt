package com.companytest.thesports.usecases

import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.domain.Team
import javax.inject.Inject

class RetrieveAllTeams @Inject constructor(private val repositoryHandler: RepositoryHandler<Team>) {
    suspend fun retrieveTeams(leagueParameter: String): List<Team> {
        return repositoryHandler.retrieveAll(leagueParameter)
    }
}