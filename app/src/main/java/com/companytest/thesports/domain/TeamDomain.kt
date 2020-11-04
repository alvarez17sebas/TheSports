package com.companytest.thesports.domain

import com.companytest.thesports.data.Repository

class TeamDomain  constructor(private val teamRepository: Repository<Team>) {

    suspend fun retrieveAllTeams(leagueParameter: String): List<Team> {
        return if (leagueParameter == "") return arrayListOf() else teamRepository.retrieveAll(
            leagueParameter
        )
    }

    suspend fun retrieveTeam(teamId: String): Team {
        return return if (teamId == "") Team() else teamRepository.retrieveById(teamId)[0]
    }
}