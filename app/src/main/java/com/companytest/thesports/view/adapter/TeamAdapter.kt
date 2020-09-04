package com.companytest.thesports.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.companytest.thesports.R
import com.companytest.thesports.databinding.ItemTeamListBinding
import com.companytest.thesports.model.Team

class TeamAdapter(private val data: List<Team>, private val teamClickListener: TeamClickListener) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemTeamListBinding = ItemTeamListBinding.inflate(inflater, parent, false)
        return TeamViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val teamItem: Team = data[position]
        holder.bindData(teamItem)
    }

    inner class TeamViewHolder(rowBinding: ItemTeamListBinding) :
        RecyclerView.ViewHolder(rowBinding.root) {

        private val itemBinding: ItemTeamListBinding = rowBinding

        init {
            executeClickListeners()
        }

        fun bindData(teamItem: Team) {
            itemBinding.tvTeamNameItem.text = teamItem.strTeam
            itemBinding.tvStadiumNameItem.text = teamItem.strStadium

            loadImage(teamItem.strTeamBadge)
        }

        private fun loadImage(strUrlImage: String) {
            Glide.with(itemBinding.root.context).load(strUrlImage)
                .placeholder(R.drawable.broken_image).into(itemBinding.ivTeamItem)
        }

        private fun executeClickListeners(){
            itemBinding.root.setOnClickListener { view ->
                teamClickListener.teamClick(data[layoutPosition])
            }
        }
    }
}