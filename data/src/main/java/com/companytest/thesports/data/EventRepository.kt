package com.companytest.thesports.data

import com.companytest.thesports.data.network.TheSportService
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.Repository
import javax.inject.Inject

class EventRepository @Inject constructor(var sportService: TheSportService) :
    Repository<Event> {

    override suspend fun retrieveAll(leagueParameter: String): List<Event> {
        return ArrayList()
    }

    override suspend fun retrieveById(id: String): List<Event> {
        return sportService.retrieveAllEventsByTeamId(id).events
    }
}