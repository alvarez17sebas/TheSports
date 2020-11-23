package com.companytest.thesports.domain.repository

import com.companytest.thesports.domain.League
import kotlinx.coroutines.flow.Flow

interface LocalLeagueRepository {
    fun saveLeagues(leagues: List<League>)
    fun getLeagues(): Flow<List<League>>
}