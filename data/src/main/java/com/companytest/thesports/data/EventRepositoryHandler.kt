package com.companytest.thesports.data

import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.EventLocalRepository
import com.companytest.thesports.domain.repository.EventRepository
import javax.inject.Inject

class EventRepositoryHandler @Inject constructor(
    var remoteRepository: EventRepository,
    var localRepository: EventLocalRepository
) {
    suspend fun retrieveAll(): List<Event> {
        return listOf()
    }

    suspend fun retrieveById(id: String): List<Event> {
        var events: List<Event> = emptyList()
        events = localRepository.getById(id)
        if(events.isEmpty()){
            events = remoteRepository.retrieveById(id)
            events.forEach {
                var event: Event = it
                event.idTeam = id
                localRepository.save(it)
            }
        }
        return events
    }
}