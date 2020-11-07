package com.companytest.thesports.data

import com.companytest.thesports.data.network.TheSportService
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class EventRepository @Inject constructor(var sportService: TheSportService) :
    Repository<Event> {

    override fun retrieveAll(leagueParameter: String): Flow<List<Event>> {
        return flowOf()
    }

    override fun retrieveById(id: String): Flow<List<Event>> {
        var flow: Flow<List<Event>> = flow {
            emit(sportService.retrieveAllEventsByTeamId(id).events)
        }.flowOn(Dispatchers.IO)

        return flow
    }

    override fun save(data: Event) {

    }
}