package com.companytest.thesports.repository.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class TeamWithEvents (
    @Embedded val teamEntity: TeamEntity,
    @Relation(
        parentColumn = "id_team",
        entityColumn = "id_team")
    val events: List<EventEntity>
)