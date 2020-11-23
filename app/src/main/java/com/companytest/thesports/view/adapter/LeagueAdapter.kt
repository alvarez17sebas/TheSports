package com.companytest.thesports.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.companytest.thesports.databinding.ItemLeagueBinding
import com.companytest.thesports.domain.League

class LeagueAdapter(private val leagues: List<League>, val leagueClick: LeagueClickListener) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemLeagueBinding = ItemLeagueBinding.inflate(layoutInflater, parent, false)
        return LeagueViewHolder(binding)
    }

    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val leagueItem: League = leagues[position]
        holder.bindData(leagueItem)
    }

    inner class LeagueViewHolder(rowBinding: ItemLeagueBinding) : RecyclerView.ViewHolder(rowBinding.root) {
        private val itemBinding: ItemLeagueBinding =  rowBinding

        init {
            executeClickListener()
        }

        fun bindData(leagueItem: League) {
            itemBinding.tvLeagueName.text = leagueItem.strLeague
        }

        private fun executeClickListener() {
            itemBinding.root.setOnClickListener {
                leagueClick.leagueClick(leagues[layoutPosition])
            }
        }
    }

}