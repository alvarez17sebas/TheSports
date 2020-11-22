package com.companytest.thesports.domain.repository

import com.companytest.thesports.domain.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface RemoteRepository<T> {
    suspend fun retrieveAll(leagueParameter: String): List<T>
    suspend fun retrieveById(id: String): List<T>
}
