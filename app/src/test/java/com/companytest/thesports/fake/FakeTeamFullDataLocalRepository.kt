package com.companytest.thesports.fake

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

class FakeTeamFullDataLocalRepository : LocalRepository<Team> {
    override suspend fun save(data: Team) {

    }

    override suspend fun saveAll(dataList: List<Team>) {
    }

    override suspend fun update(data: Team) {
    }

    override fun getAll(leagueParameter: String): Flow<List<Team>> {
        return flowOf(listOf<Team>(Team("1", "Team One"), Team("2", "Team Two")))
    }

    override fun getById(id: String): Flow<List<Team>> {
        return flowOf(listOf(Team("3", "Team tree")))
    }

    override suspend fun delete(data: Team) {
    }
}