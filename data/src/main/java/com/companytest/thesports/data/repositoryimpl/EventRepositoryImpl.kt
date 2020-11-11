package com.companytest.thesports.data.repositoryimpl

import com.companytest.thesports.data.datasource.network.TheSportService
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.RemoteRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(var sportService: TheSportService) :
    RemoteRepository<Event> {

    override suspend fun retrieveAll(leagueParameter: String): List<Event> {
        return listOf()
    }

    override suspend fun retrieveById(id: String): List<Event> {
        return sportService.retrieveAllEventsByTeamId(id).events
    }

}