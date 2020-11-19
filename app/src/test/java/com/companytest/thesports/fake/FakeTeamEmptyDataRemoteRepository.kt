package com.companytest.thesports.fake

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class FakeTeamEmptyDataRemoteRepository : RemoteRepository<Team> {
    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return listOf<Team>()
    }

    override fun retrieveById(id: String): Flow<List<Team>> {
        return emptyFlow()
    }
}