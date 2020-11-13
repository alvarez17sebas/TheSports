package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.datasource.database.dao.EventDao
import com.companytest.thesports.datasource.database.entity.EventEntity
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.mapping.EventMapping
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

    override fun getAll(leagueParameter: String): Flow<List<Event>> {
        return eventDao.getAll().map {
            EventMapping.toListEventDomain(it)
        }
    }

    override fun getById(id: String): Flow<List<Event>> {
        return eventDao.getById(id).map {
            EventMapping.toListEventDomain(it)
        }
    }

    override suspend fun delete(data: Event) {
        val eventEntity: EventEntity = EventMapping.toEventEntity(data)
        eventDao.delete(eventEntity)
    }

}