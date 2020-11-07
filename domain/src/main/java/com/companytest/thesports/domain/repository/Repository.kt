package com.companytest.thesports.domain.repository

interface Repository <T> {
    suspend fun retrieveAll(leagueParameter: String): List<T>
    suspend fun retrieveById(id: String): List<T>
}