package com.companytest.thesports.repository

interface RemoteRepository<T> {
    suspend fun retrieveAll(leagueParameter: String): List<T>
    suspend fun retrieveById(id: String): List<T>
}