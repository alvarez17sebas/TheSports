package com.companytest.thesports.usecases

import com.companytest.thesports.data.EventRepositoryHandler
import com.companytest.thesports.domain.Event
import javax.inject.Inject

class RetrieveAllEventsByTeamId @Inject constructor(private val eventRepositoryRepositoryHandler: EventRepositoryHandler){
     suspend fun retrieveEventsByTeamId(id: String): List<Event>{
        return eventRepositoryRepositoryHandler.retrieveById(id)
    }
}