package com.companytest.thesports.repository.database.operation

import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Event
import com.companytest.thesports.mapping.EventMapping
import com.companytest.thesports.repository.database.dao.EventDao
import com.companytest.thesports.repository.database.entity.EventEntity

class OperationEventLocalDatabaseImpl constructor(var eventDao: EventDao) : OperationLocalDatabase<Event> {
    override suspend fun save(data: Event) {
        val eventEntity: EventEntity = EventMapping.toEventEntity(data)
        eventDao.save(eventEntity)
    }

    override suspend fun saveAll(dataList: List<Event>) {

    }

    override suspend fun update(data: Event) {
    }

    override suspend fun getAll(): List<Event> {
        val events: List<Event> = EventMapping.toListEventDomain(eventDao.getAll())
        return events
    }

    override suspend fun getById(id: String): List<Event> {
        val events: List<Event> = EventMapping.toListEventDomain(eventDao.getById(id))
        return events
    }

    override suspend fun delete(data: Event) {
        val eventEntity: EventEntity = EventMapping.toEventEntity(data)
        eventDao.delete(eventEntity)
    }
}