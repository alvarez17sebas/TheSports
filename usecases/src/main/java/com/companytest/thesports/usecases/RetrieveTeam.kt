package com.companytest.thesports.usecases

import com.companytest.thesports.data.Repository
import com.companytest.thesports.domain.Team

class RetrieveTeam(private val repository: Repository<Team>) {
    suspend fun retrieveTeam(id: String): Team {
        return repository.retrieveById(id)[0]
    }
}