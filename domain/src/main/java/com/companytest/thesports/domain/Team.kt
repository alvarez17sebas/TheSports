package com.companytest.thesports.domain

data class TeamResponse(val teams: List<Team>)

data class Team(
    val idTeam: String = "",
    val strTeam: String = "",
    val intFormedYear: String = "",
    val strStadium: String = "",
    val strWebsite: String = "",
    val strFacebook: String = "",
    val strTwitter: String = "",
    val strInstagram: String = "",
    val strDescriptionEN: String = "",
    val strTeamBadge: String = "",
    val strTeamJersey: String? = "",
    val strYoutube: String = ""
)