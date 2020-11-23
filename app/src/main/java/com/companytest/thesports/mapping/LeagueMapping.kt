package com.companytest.thesports.mapping

import com.companytest.thesports.datasource.database.entity.LeagueEntity
import com.companytest.thesports.domain.League

class LeagueMapping {
    companion object {
        fun toLeagueEntity(league: League): LeagueEntity {
            return LeagueEntity(league.idLeague, league.strLeague)
        }

        fun toLeagueDomain(leagueEntity: LeagueEntity): League {
            return League(leagueEntity.id, leagueEntity.league_name)
        }

        fun toListLeagueEntity(leagues: List<League>): List<LeagueEntity> {
            var leaguesEntity: MutableList<LeagueEntity> = mutableListOf()
            leagues.forEach {
                val league: LeagueEntity = toLeagueEntity(it)
                leaguesEntity.add(league)
            }
            return leaguesEntity
        }

        fun toListLeagueDomain(leaguesEntity: List<LeagueEntity>): List<League> {
            var leagues: MutableList<League> = mutableListOf()
            leaguesEntity.forEach {
                val league: League = toLeagueDomain(it)
                leagues.add(league)
            }
            return leagues
        }
    }
}