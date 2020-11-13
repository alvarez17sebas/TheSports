package com.companytest.thesports.domain.repository

import kotlinx.coroutines.flow.Flow

interface RemoteRepository<T> {
    fun retrieveAll(leagueParameter: String): Flow<List<T>>
    fun retrieveById(id: String): Flow<List<T>>
}