package com.companytest.thesports.usecases

import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RetrieveTeam @Inject constructor(private val teamRepositoryRepositoryHandler: TeamRepositoryHandler) {
    fun retrieveTeam(id: String): Flow<ResultWrapper<Team>> {
        return teamRepositoryRepositoryHandler.retrieveById(id).map {
            var response: ResultWrapper<Team> = when(it) {
                is ResultWrapper.Loading -> {
                    it
                }
                is ResultWrapper.Success -> {
                    ResultWrapper.Success(it.data[0])
                }
                is ResultWrapper.Error -> {
                    it
                }
            }
            response
        }
    }
}