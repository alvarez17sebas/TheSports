package com.companytest.thesports.repository

import com.companytest.thesports.model.Event
import javax.inject.Inject

class EventRepository @Inject constructor(): RemoteRepository<Event> {

    private var sportService: SportService = RetrofitClient.getSportService()

    override suspend fun retrieveAll(): List<Event> {
        return ArrayList()
    }

    override suspend fun retrieveById(id: String): List<Event> {
        return sportService.retrieveAllEventsByTeamId(id).events
    }
}