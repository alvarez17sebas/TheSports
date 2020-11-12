package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.mapping.EventMapping
import com.companytest.thesports.datasource.database.dao.EventDao
import com.companytest.thesports.datasource.database.entity.EventEntity
import javax.inject.Inject

class EventLocalDatabaseImpl @Inject constructor(var eventDao: EventDao) : LocalRepository<Event> {
    override suspend fun save(data: Event) {
        val eventEntity: EventEntity = EventMapping.toEventEntity(data)
        eventDao.save(eventEntity)
    }

    override suspend fun saveAll(dataList: List<Event>) {

    }

    override suspend fun update(data: Event) {
    }

    override suspend fun getAll(leagueParameter: String): List<Event> {
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