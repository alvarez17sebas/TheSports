package com.companytest.thesports.domain.repository

interface LocalRepository<T> {
    suspend fun save(data: T)

    suspend fun saveAll(dataList: List<T>)

    suspend fun update(data: T)

    suspend fun getAll(leagueParameter: String): List<T>

    suspend fun getById(id: String): List<T>

    suspend fun delete(data: T)
}