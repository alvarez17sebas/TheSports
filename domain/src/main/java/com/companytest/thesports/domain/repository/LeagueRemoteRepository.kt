package com.companytest.thesports.domain.repository

import com.companytest.thesports.domain.League

interface LeagueRemoteRepository {
    suspend fun retrieveAllLeagues(): List<League>
}