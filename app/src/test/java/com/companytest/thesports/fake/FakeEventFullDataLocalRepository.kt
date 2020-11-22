package com.companytest.thesports.fake

import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

class FakeEventFullDataLocalRepository : LocalRepository<Event> {
    override suspend fun save(data: Event) {

    }

    override suspend fun saveAll(dataList: List<Event>) {

    }

    override suspend fun update(data: Event) {

    }

    override fun getAll(leagueParameter: String): Flow<List<Event>> {
        return emptyFlow()
    }

    override fun getById(id: String): Flow<List<Event>> {
        return flowOf(listOf(Event("1"), Event("2"), Event("3")))
    }

    override suspend fun delete(data: Event) {

    }
}