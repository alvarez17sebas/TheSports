package com.companytest.thesports.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.companytest.thesports.R
import com.companytest.thesports.databinding.ActivityTeamDetailBinding
import com.companytest.thesports.model.Event
import com.companytest.thesports.model.Team
import com.companytest.thesports.view.TEAM_ID
import com.companytest.thesports.view.adapter.EventAdapter
import com.companytest.thesports.viewmodel.TeamDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_team_detail.*

@AndroidEntryPoint
class TeamDetailActivity : AppCompatActivity() {

    private val teamDetailViewModel: TeamDetailViewModel by viewModels()
    private lateinit var teamId: String
    private lateinit var binding: ActivityTeamDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupDataBinding()

        receiveTeamId()

        teamDetailViewModel.retrieveTeam(teamId)
        teamDetailViewModel.retrieveNextEventsByTeamId(teamId)

        setupEventRecyclerView()

        executeObservers()
    }

    private fun receiveTeamId() {
        teamId = intent.getStringExtra(TEAM_ID)!!
    }

    private fun setupDataBinding(){
        binding = ActivityTeamDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupEventRecyclerView(){
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTeamEvents.layoutManager = layoutManager
    }

    private fun setRecyclerEventData(events: List<Event>){
        with(binding.rvTeamEvents){
            adapter = EventAdapter(events)
        }
    }

    private fun executeObservers(){
        teamDetailViewModel.teamLiveData.observe(this, Observer {team: Team ->
            binding.toolbar.title = (team.strTeam)
            binding.tvTeamFoundationYear.text = team.intFormedYear
            binding.tvDescriptionTeamDetail.text = team.strDescriptionES
            loadImage(team.strTeamBadge)
        })

        teamDetailViewModel.eventsLiveData.observe(this, Observer { events: List<Event> ->
            setRecyclerEventData(events)
        })
    }

    private fun loadImage(strUrlImage: String) {
        Glide.with(this).load(strUrlImage)
            .placeholder(R.drawable.broken_image).into(binding.ivCoverPhoto)
    }
}