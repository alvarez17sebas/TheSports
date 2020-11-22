package com.companytest.thesports.fake

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

class FakeTeamEmptyDataLocalRepository : LocalRepository<Team> {
    override suspend fun save(data: Team) {

    }

    override suspend fun saveAll(dataList: List<Team>) {
    }

    override suspend fun update(data: Team) {
    }

    override fun getAll(leagueParameter: String): Flow<List<Team>> {
        return flowOf(listOf<Team>())
    }

    override fun getById(id: String): Flow<List<Team>> {
        return emptyFlow()
    }

    override suspend fun delete(data: Team) {
    }
}