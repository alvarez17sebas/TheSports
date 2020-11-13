package com.companytest.thesports.mapping

import com.companytest.thesports.domain.Event
import com.companytest.thesports.datasource.database.entity.EventEntity

class EventMapping {
    companion object {
        fun toEventEntity(event: Event): EventEntity {
            return EventEntity(event.idEvent, event.idTeam, event.strEvent)
        }

        fun toEventDomain(eventEntity: EventEntity): Event {
            return Event(eventEntity.id, eventEntity.id_team, eventEntity.str_event)
        }

        fun toListEventEntity(events: List<Event>): List<EventEntity> {
            var eventsEntity: MutableList<EventEntity> = mutableListOf()
            events.forEach {
                val event: EventEntity = toEventEntity(it)
                eventsEntity.add(event)
            }
            return eventsEntity
        }

        fun toListEventDomain(eventsEntity: List<EventEntity>): List<Event> {
            var events: MutableList<Event> = mutableListOf()
            eventsEntity.forEach {
                val event: Event = toEventDomain(it)
                events.add(event)
            }
            return events
        }
    }
}