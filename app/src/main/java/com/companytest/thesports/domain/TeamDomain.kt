package com.companytest.thesports.domain

import com.companytest.thesports.model.Team
import com.companytest.thesports.repository.RemoteRepository
import javax.inject.Inject

class TeamDomain @Inject constructor(private val teamRepository: RemoteRepository<Team>){

    suspend fun retrieveAllTeams(): List<Team>{
        return teamRepository.retrieveAll()
    }

    suspend fun retrieveTeam(teamId: String): Team{
        return teamRepository.retrieveById(teamId)
    }
}