package com.companytest.thesports.domain.repository

import kotlinx.coroutines.flow.Flow

interface LocalRepository<T> {
    suspend fun save(data: T)

    suspend fun saveAll(dataList: List<T>)

    suspend fun update(data: T)

    fun getAll(leagueParameter: String): Flow<List<T>>

    fun getById(id: String): Flow<List<T>>

    suspend fun delete(data: T)
}