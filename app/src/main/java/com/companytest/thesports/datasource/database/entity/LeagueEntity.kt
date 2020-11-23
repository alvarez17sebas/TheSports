package com.companytest.thesports.datasource.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league")
data class LeagueEntity (
    @PrimaryKey var id: String,
    var league_name: String
)