package com.companytest.thesports.datasource.database.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.companytest.thesports.datasource.database.entity.EventEntity
import com.companytest.thesports.datasource.database.entity.TeamEntity

data class TeamWithEvents (
    @Embedded val teamEntity: TeamEntity,
    @Relation(
        parentColumn = "id_team",
        entityColumn = "id_team")
    val events: List<EventEntity>
)