package com.companytest.thesports.usecases

import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.domain.Event
import javax.inject.Inject

class RetrieveAllEventsByTeamId @Inject constructor(private val repositoryHandler: RepositoryHandler<Event>){
    suspend fun retrieveEventsByTeamId(id: String): List<Event>{
        return repositoryHandler.retrieveById(id)
    }
}