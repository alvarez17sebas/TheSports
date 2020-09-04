package com.companytest.thesports.domain

import com.companytest.thesports.model.Event
import com.companytest.thesports.repository.RemoteRepository
import javax.inject.Inject

class EventDomain @Inject constructor(val remoteRepository: RemoteRepository<Event>){

    suspend fun retrieveAllEventsByTeamId(teamId: String): List<Event>{
        return remoteRepository.retrieveById(teamId)
    }
}
