package com.companytest.thesports.data

import com.companytest.thesports.domain.repository.Repository
import com.companytest.thesports.domain.repository.TeamLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryHandler<T> @Inject constructor(private val remoteRepository: Repository<T>,  private val localRepository: TeamLocalRepository) {

    fun retrieveAll(leagueParameter: String): Flow<List<T>>{

        val dataList = remoteRepository.retrieveAll(leagueParameter)
        return remoteRepository.retrieveAll(leagueParameter)
    }

    fun retrieveById(id: String): Flow<List<T>>{
        return remoteRepository.retrieveById(id)
    }
}