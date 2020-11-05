package com.companytest.thesports.data

interface Repository <T> {
    suspend fun retrieveAll(leagueParameter: String): List<T>
    suspend fun retrieveById(id: String): List<T>
}