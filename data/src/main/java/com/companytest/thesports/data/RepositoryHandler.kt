package com.companytest.thesports.data

class RepositoryHandler<T>(private val repository: Repository<T>) {

    suspend fun retrieveAll(leagueParameter: String): List<T>{
        return repository.retrieveAll(leagueParameter)
    }

    suspend fun retrieveById(id: String): List<T>{
        return repository.retrieveById(id)
    }
}