package com.companytest.thesports.usecases

import com.companytest.thesports.data.team.EventRepositoryHandler
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.ResultWrapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveAllEventsByTeamId @Inject constructor(private val eventRepositoryRepositoryHandler: EventRepositoryHandler) {
     fun retrieveEventsByTeamId(id: String): Flow<ResultWrapper<List<Event>>> {
        return eventRepositoryRepositoryHandler.retrieveById(id)
    }
}