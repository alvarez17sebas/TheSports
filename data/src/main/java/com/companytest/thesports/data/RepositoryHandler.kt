package com.companytest.thesports.data

import com.companytest.thesports.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryHandler<T> @Inject constructor(private val repository: Repository<T>) {

    fun retrieveAll(leagueParameter: String): Flow<List<T>>{
        return repository.retrieveAll(leagueParameter)
    }

    fun retrieveById(id: String): Flow<List<T>>{
        return repository.retrieveById(id)
    }
}