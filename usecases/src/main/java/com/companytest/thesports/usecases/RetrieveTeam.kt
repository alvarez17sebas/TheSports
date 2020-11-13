package com.companytest.thesports.usecases

import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.Team
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RetrieveTeam @Inject constructor(private val teamRepositoryRepositoryHandler: TeamRepositoryHandler) {
    suspend fun retrieveTeam(id: String): Flow<Team> {
        return teamRepositoryRepositoryHandler.retrieveById(id).map {
            it[0]
        }
    }
    /*fun retrieveTeam(id: String): Flow<Team> {
        return teamRepository.retrieveById(id).map {
            it[0]
        }
    }*/
}