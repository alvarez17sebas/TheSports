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
            var list: List<Team> = (it as ResultWrapper.Success).data
            val result: ResultWrapper<Team> = ResultWrapper.Success(list[0])
            result
        }
    }
}