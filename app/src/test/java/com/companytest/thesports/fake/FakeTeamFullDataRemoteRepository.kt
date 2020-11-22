package com.companytest.thesports.fake

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.RemoteRepository

class FakeTeamFullDataRemoteRepository : RemoteRepository<Team> {
    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return listOf<Team>(Team("1", "Team One"), Team("2", "Team Two"))
    }

    override suspend fun retrieveById(id: String): List<Team> {
        return listOf(Team("3", "Team tree"))
    }
}