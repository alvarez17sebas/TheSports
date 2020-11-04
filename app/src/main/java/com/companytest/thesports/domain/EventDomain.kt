package com.companytest.thesports.domain

import com.companytest.thesports.data.Repository
import javax.inject.Inject

class EventDomain @Inject constructor(val remoteRepository: Repository<Event>){

    suspend fun retrieveAllEventsByTeamId(teamId: String): List<Event>{
        return remoteRepository.retrieveById(teamId)
    }
}
