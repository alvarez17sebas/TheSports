package com.companytest.thesports.fake

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

class FakeTeamEmptyDataRemoteRepository : RemoteRepository<Team> {
    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return listOf<Team>()
    }

    override suspend fun retrieveById(id: String): List<Team> {
        return listOf(Team("3", "Team tree"))
    }
}