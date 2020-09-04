package com.companytest.thesports.domain

import com.companytest.thesports.model.Team
import com.companytest.thesports.repository.RemoteRepository
import javax.inject.Inject

class TeamDomain @Inject constructor(private val teamRepository: RemoteRepository<Team>) {

    suspend fun retrieveAllTeams(leagueParameter: String): List<Team> {
        return if (leagueParameter == "") return arrayListOf() else teamRepository.retrieveAll(
            leagueParameter
        )
    }

    suspend fun retrieveTeam(teamId: String): Team {
        return return if (teamId == "") Team() else teamRepository.retrieveById(teamId)[0]
    }
}