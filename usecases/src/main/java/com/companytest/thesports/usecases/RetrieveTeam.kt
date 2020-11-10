package com.companytest.thesports.usecases

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RetrieveTeam @Inject constructor(private val teamRepository: TeamRepository) {
    suspend fun retrieveTeam(id: String): Team {
        return teamRepository.retrieveById(id)[0]
    }
    /*fun retrieveTeam(id: String): Flow<Team> {
        return teamRepository.retrieveById(id).map {
            it[0]
        }
    }*/
}