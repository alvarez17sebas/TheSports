package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.datasource.network.SportService
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.RemoteRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(var sportService: SportService) :
    RemoteRepository<Event> {

    override suspend fun retrieveAll(leagueParameter: String): List<Event> {
        return listOf()
    }

    override suspend fun retrieveById(id: String): List<Event> {
        return sportService.retrieveAllEventsByTeamId(id).events
    }

}