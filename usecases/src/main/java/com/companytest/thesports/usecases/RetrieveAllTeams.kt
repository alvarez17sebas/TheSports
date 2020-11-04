package com.companytest.thesports.usecases

import com.companytest.thesports.data.Repository
import com.companytest.thesports.domain.Team

class RetrieveAllTeams(private val repository: Repository<Team>) {
    suspend fun retrieveTeams(leagueParameter: String): List<Team> {
        return repository.retrieveAll(leagueParameter)
    }
}