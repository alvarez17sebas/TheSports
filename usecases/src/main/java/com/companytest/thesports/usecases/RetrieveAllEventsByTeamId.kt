package com.companytest.thesports.usecases

import com.companytest.thesports.data.EventRepositoryHandler
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveAllEventsByTeamId @Inject constructor(private val teamRepositoryHandler: EventRepositoryHandler){
     suspend fun retrieveEventsByTeamId(id: String): List<Event>{
        return teamRepositoryHandler.retrieveById(id)
    }
}