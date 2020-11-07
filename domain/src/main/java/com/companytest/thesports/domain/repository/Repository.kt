package com.companytest.thesports.domain.repository

import kotlinx.coroutines.flow.Flow

interface Repository <T> {
    fun save(data: T)
    fun retrieveAll(leagueParameter: String): Flow<List<T>>
    fun retrieveById(id: String): Flow<List<T>>
}