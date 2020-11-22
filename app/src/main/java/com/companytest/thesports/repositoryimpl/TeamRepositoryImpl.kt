package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.datasource.network.SportService
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(val sportService: SportService) :
    RemoteRepository<Team> {
    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return sportService.retrieveAllTeams(leagueParameter).teams
    }

    override suspend fun retrieveById(id: String): List<Team> {
        return sportService.retrieveTeam(id).teams
    }
}