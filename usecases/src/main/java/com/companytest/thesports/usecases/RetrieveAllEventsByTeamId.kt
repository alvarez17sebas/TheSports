package com.companytest.thesports.usecases

import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.domain.Event
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveAllEventsByTeamId @Inject constructor(private val repositoryHandler: RepositoryHandler<Event>){
     fun retrieveEventsByTeamId(id: String): Flow<List<Event>>{
        return repositoryHandler.retrieveById(id)
    }
}