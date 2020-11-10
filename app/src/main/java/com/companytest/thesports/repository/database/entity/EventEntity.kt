package com.companytest.thesports.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class EventEntity(
    @PrimaryKey
    var id: String,
    val id_team: String = "",
    val str_event: String = ""
)