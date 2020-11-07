package com.companytest.thesports.data

import com.companytest.thesports.domain.repository.Repository
import javax.inject.Inject

class RepositoryHandler<T> @Inject constructor(private val repository: Repository<T>) {

    suspend fun retrieveAll(leagueParameter: String): List<T>{
        return repository.retrieveAll(leagueParameter)
    }

    suspend fun retrieveById(id: String): List<T>{
        return repository.retrieveById(id)
    }
}