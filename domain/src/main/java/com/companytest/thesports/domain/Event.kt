package com.companytest.thesports.domain

data class ResponseEvent(val events: List<Event>)

data class Event(
    val strEvent: String = ""
)