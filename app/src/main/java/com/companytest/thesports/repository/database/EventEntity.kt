package com.companytest.thesports.repository.database

import androidx.room.Entity

@Entity(tableName = "event")
data class EventEntity (
    val str_event: String = ""
)