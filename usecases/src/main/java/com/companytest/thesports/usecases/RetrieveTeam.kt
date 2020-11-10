package com.companytest.thesports.usecases

import com.companytest.thesports.data.handler.TeamRepositoryHandler
import com.companytest.thesports.domain.Team
import javax.inject.Inject

class RetrieveTeam @Inject constructor(private val teamRepositoryRepositoryHandler: TeamRepositoryHandler) {
    suspend fun retrieveTeam(id: String): Team {
        return teamRepositoryRepositoryHandler.retrieveById(id)[0]
    }
    /*fun retrieveTeam(id: String): Flow<Team> {
        return teamRepository.retrieveById(id).map {
            it[0]
        }
    }*/
}