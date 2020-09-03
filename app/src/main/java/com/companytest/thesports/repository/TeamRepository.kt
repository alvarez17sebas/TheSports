package com.companytest.thesports.repository

import com.companytest.thesports.model.Team

class TeamRepository : RemoteRepository<Team> {
    override suspend fun retrieveAll(): List<Team> {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveById(): Team {
        TODO("Not yet implemented")
    }
}