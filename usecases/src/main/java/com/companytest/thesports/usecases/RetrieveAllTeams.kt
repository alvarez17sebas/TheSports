package com.companytest.thesports.usecases

import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.domain.Team
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveAllTeams @Inject constructor(private val repositoryHandler: RepositoryHandler<Team>) {
    fun retrieveTeams(leagueParameter: String): Flow<List<Team>> {
        return repositoryHandler.retrieveAll(leagueParameter)
    }
}