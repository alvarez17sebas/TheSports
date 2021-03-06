package com.companytest.thesports.repository.fake

import com.companytest.thesports.model.Team
import com.companytest.thesports.repository.RemoteRepository
import com.google.gson.Gson

class TeamFakeRepository : RemoteRepository<Team> {

    var teams: MutableList<Team> = arrayListOf()

    init {
        var team: Team = Gson().fromJson(JSON_SIMULATION_1, Team::class.java)
        var team2: Team = Gson().fromJson(JSON_SIMULATION_1, Team::class.java)

        teams.add(team)
        teams.add(team2)
    }

    override suspend fun retrieveAll(leagueParameter: String): List<Team> {
        return teams
    }

    override suspend fun retrieveById(id: String): List<Team> {
        var teamList: MutableList<Team> = arrayListOf()

        for (teamIndex: Team in teams) {
            if (id == teamIndex.idTeam) teamList.add(teamIndex)
        }

        return teamList
    }
}