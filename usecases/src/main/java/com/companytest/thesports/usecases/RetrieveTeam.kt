package com.companytest.thesports.usecases

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RetrieveTeam @Inject constructor(private val repository: Repository<Team>) {
    fun retrieveTeam(id: String): Flow<Team> {
        return repository.retrieveById(id).map {
            it[0]
        }
    }
}