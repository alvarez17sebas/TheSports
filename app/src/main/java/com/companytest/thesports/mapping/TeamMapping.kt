package com.companytest.thesports.mapping

import com.companytest.thesports.domain.Team
import com.companytest.thesports.datasource.database.entity.TeamEntity

class TeamMapping {
    companion object {
        fun toTeamEntity(team: Team): TeamEntity {
            return TeamEntity(
                team.idTeam,
                team.strTeam,
                team.intFormedYear,
                team.strStadium,
                team.strWebsite,
                team.strFacebook,
                team.strTwitter,
                team.strInstagram,
                team.strDescriptionEN,
                team.strTeamBadge,
                team.strTeamJersey,
                team.strYoutube
            )
        }

        fun toTeamDomain(teamEntity: TeamEntity): Team {
            return Team(
                teamEntity.id_team,
                teamEntity.str_team,
                teamEntity.int_formedYear,
                teamEntity.strS_stadium,
                teamEntity.str_website,
                teamEntity.str_facebook,
                teamEntity.str_twitter,
                teamEntity.str_instagram,
                teamEntity.str_descriptionEN,
                teamEntity.str_teamBadge,
                teamEntity.st_teamJersey,
                teamEntity.str_youtube
            )
        }

        fun toListTeamEntity(teams: List<Team>): List<TeamEntity>{
            val teamsEntity: MutableList<TeamEntity> = mutableListOf()
            teams.forEach {
                val teamEntity: TeamEntity = toTeamEntity(it)
                teamsEntity.add(teamEntity)
            }
            return teamsEntity
        }

        fun toListTeamDomain(teamsEntity: List<TeamEntity>): List<Team> {
            val teams: MutableList<Team> = mutableListOf()
            teamsEntity.forEach {
                val team: Team = toTeamDomain(it)
                teams.add(team)
            }
            return teams
        }
    }
}