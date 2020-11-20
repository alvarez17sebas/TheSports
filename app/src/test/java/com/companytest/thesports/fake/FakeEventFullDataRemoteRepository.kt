package com.companytest.thesports.fake

import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.RemoteRepository

class FakeEventFullDataRemoteRepository : RemoteRepository<Event> {
    override suspend fun retrieveAll(leagueParameter: String): List<Event> {
        return listOf()
    }

    override suspend fun retrieveById(id: String): List<Event> {
        return listOf(Event("1"), Event("2"), Event("3"))
    }
}