package com.companytest.thesports.domain.repository

import com.companytest.thesports.domain.Event
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    suspend fun retrieveAll(leagueParameter: String): List<Event>
    suspend fun retrieveById(id: String): List<Event>
}