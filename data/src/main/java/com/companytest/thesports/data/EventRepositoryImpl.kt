package com.companytest.thesports.data

import com.companytest.thesports.data.network.TheSportService
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.EventRepository
import com.companytest.thesports.domain.repository.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(var sportService: TheSportService) :
    EventRepository {

    override suspend fun retrieveAll(leagueParameter: String): List<Event> {
        return listOf()
    }

    override suspend fun retrieveById(id: String): List<Event> {
        return sportService.retrieveAllEventsByTeamId(id).events
    }

    /*override fun retrieveById(id: String): Flow<List<Event>> {
        var flow: Flow<List<Event>> = flow {
            emit(sportService.retrieveAllEventsByTeamId(id).events)
        }.flowOn(Dispatchers.IO)

        return flow
    }*/

}