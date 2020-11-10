package com.companytest.thesports.data

import com.companytest.thesports.data.network.TheSportService
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.RemoteRepository
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(var sportService: TheSportService) :
    RemoteRepository<Team> {

    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return sportService.retrieveAllTeams(leagueParameter).teams
    }

    override suspend fun retrieveById(id: String): List<Team> {
        return sportService.retrieveTeam(id).teams
    }

    /*override fun retrieveAll(leagueParameter: String): Flow<List<Team>> {
        var flow: Flow<List<Team>> = flow {
            emit(sportService.retrieveAllTeams(leagueParameter).teams)
        }.flowOn(Dispatchers.IO)

        return flow
    }

    override fun retrieveById(teamId: String): Flow<List<Team>> {
        var flow: Flow<List<Team>> = flow {
            emit(sportService.retrieveTeam(teamId).teams)
        }.flowOn(Dispatchers.IO)

        return flow
    }

    override fun save(data: Team) {

    }*/
}