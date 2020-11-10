package com.companytest.thesports.domain.repository

import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team

interface EventLocalRepository {
    suspend fun save(event: Event)

    suspend fun saveAll(events: List<Event>)

    suspend fun update(event: Event)

    suspend fun getAll(leagueParameter: String): List<Event>

    suspend fun getById(id: String): List<Event>

    suspend fun delete(event: Event)
}