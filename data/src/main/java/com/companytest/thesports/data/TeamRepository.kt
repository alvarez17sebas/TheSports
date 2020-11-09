package com.companytest.thesports.data

import com.companytest.thesports.data.network.TheSportService
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TeamRepository @Inject constructor(var sportService: TheSportService) :
    Repository<Team> {

    override fun retrieveAll(leagueParameter: String): Flow<List<Team>> {
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

    }

}