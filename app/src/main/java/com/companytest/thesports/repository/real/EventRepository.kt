package com.companytest.thesports.repository.real

import com.companytest.thesports.data.Repository
import com.companytest.thesports.domain.Event
import javax.inject.Inject

class EventRepository @Inject constructor() :
    Repository<Event> {

    private var sportService: SportService =
        RetrofitClient.getSportService()

    override suspend fun retrieveAll(leagueParameter: String): List<Event> {
        return ArrayList()
    }

    override suspend fun retrieveById(id: String): List<Event> {
        return sportService.retrieveAllEventsByTeamId(id).events
    }
}