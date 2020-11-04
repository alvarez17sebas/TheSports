package com.companytest.thesports.usecases

import com.companytest.thesports.data.Repository
import com.companytest.thesports.domain.Event
import javax.inject.Inject

class RetrieveAllEventsByTeamId @Inject constructor(val repository: Repository<Event>){
    suspend fun retrieveEventsByTeamId(id: String): List<Event>{
        return repository.retrieveById(id)
    }
}