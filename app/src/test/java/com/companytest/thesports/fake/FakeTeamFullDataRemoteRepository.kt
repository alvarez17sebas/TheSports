package com.companytest.thesports.fake

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class FakeTeamFullDataRemoteRepository : RemoteRepository<Team> {
    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return listOf<Team>(Team("1", "Team One"), Team("2", "Team Two"))
    }

    override fun retrieveById(id: String): Flow<List<Team>> {
        return emptyFlow()
    }
}