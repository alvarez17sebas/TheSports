package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.datasource.network.SportService
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(val sportService: SportService) :
    RemoteRepository<Team> {
    override fun retrieveAll(leagueParameter: String): Flow<List<Team>> {
        return flow<List<Team>> {
            emit(sportService.retrieveAllTeams(leagueParameter).teams)
        }.flowOn(Dispatchers.IO)
    }

    override fun retrieveById(id: String): Flow<List<Team>> {
        return flow {
            emit(sportService.retrieveTeam(id).teams)
        }.flowOn(Dispatchers.IO)
    }
}