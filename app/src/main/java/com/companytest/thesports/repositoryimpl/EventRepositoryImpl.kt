package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.datasource.network.SportService
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(var sportService: SportService) :
    RemoteRepository<Event> {

    override suspend fun retrieveAll(leagueParameter: String): List<Event> {
        return emptyList()
    }

    override fun retrieveById(id: String): Flow<List<Event>> {
        return flow<List<Event>> {
            emit(sportService.retrieveAllEventsByTeamId(id).events)
        }.flowOn(Dispatchers.IO)
    }

}