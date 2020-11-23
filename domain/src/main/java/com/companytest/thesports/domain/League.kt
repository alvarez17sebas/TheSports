package com.companytest.thesports.domain

data class LeagueResponse(val leagues: List<League>)

data class League(val idLeague: String, val strLeague: String)