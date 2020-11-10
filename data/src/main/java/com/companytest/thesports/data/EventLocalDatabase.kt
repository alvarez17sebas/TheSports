package com.companytest.thesports.data

import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.LocalRepository
import javax.inject.Inject

class EventLocalDatabase @Inject constructor(var operationLocalDatabase: OperationLocalDatabase<Event>) : LocalRepository<Event> {
    override suspend fun save(event: Event) {
        operationLocalDatabase.save(event)
    }

    override suspend fun saveAll(events: List<Event>) {
        operationLocalDatabase.saveAll(events)
    }

    override suspend fun update(event: Event) {
        operationLocalDatabase.update(event)
    }

    override suspend fun getAll(leagueParameter: String): List<Event> {
        return operationLocalDatabase.getAll()
    }

    override suspend fun getById(id: String): List<Event> {
        return operationLocalDatabase.getById(id)
    }

    override suspend fun delete(event: Event) {
        operationLocalDatabase.delete(event)
    }
}