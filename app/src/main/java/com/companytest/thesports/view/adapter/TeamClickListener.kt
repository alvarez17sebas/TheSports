package com.companytest.thesports.view.adapter

import com.companytest.thesports.domain.Team


interface TeamClickListener {
    fun teamClick(team: Team)
}