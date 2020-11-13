package com.companytest.thesports.usecases

import com.companytest.thesports.data.EventRepositoryHandler
import com.companytest.thesports.domain.Event
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveAllEventsByTeamId @Inject constructor(private val eventRepositoryRepositoryHandler: EventRepositoryHandler) {
     fun retrieveEventsByTeamId(id: String): Flow<List<Event>> {
        return eventRepositoryRepositoryHandler.retrieveById(id)
    }
}