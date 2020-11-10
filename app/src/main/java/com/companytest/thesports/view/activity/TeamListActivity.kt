package com.companytest.thesports.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.companytest.thesports.R
import com.companytest.thesports.databinding.ActivityTeamListBinding
import com.companytest.thesports.domain.Team
import com.companytest.thesports.view.TEAM_ID
import com.companytest.thesports.view.adapter.TeamAdapter
import com.companytest.thesports.view.adapter.TeamClickListener
import com.companytest.thesports.viewmodel.TeamListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamListActivity : AppCompatActivity(), TeamClickListener {

    private val teamListViewModel: TeamListViewModel by viewModels()
    private lateinit var binding: ActivityTeamListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDataBinding()
        setupRecyclerView()

        teamListViewModel.retrieveAllTeams(getString(R.string.spanish_league))

        radioButtonsClick()
        executeObserves()
    }

    private fun setupDataBinding(){
        binding = ActivityTeamListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupRecyclerView(){
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvTeamList.layoutManager = layoutManager
    }

    private fun setRecycleData(teams: List<Team>){
        with(binding.rvTeamList){
            adapter = TeamAdapter(teams, this@TeamListActivity)
        }
    }

    private fun executeObserves(){
        teamListViewModel.teamsLiveData
            .observe(this, Observer {teams: List<Team> ->
                setRecycleData(teams)
            })

        teamListViewModel.loading.observe(this, Observer { isLoading: Boolean ->
            if(isLoading) binding.clLoadingContainer.visibility = View.VISIBLE else binding.clLoadingContainer.visibility = View.GONE

        })
    }

    private fun radioButtonsClick(){
        var leagueParameter: String = getString(R.string.spanish_league)
        binding.rbSpanishLeague.setOnClickListener {
            leagueParameter = binding.rbSpanishLeague.text.toString()
            teamListViewModel.retrieveAllTeams(leagueParameter)
        }

        binding.rbGermanLeague.setOnClickListener {
            leagueParameter = binding.rbGermanLeague.text.toString()
            teamListViewModel.retrieveAllTeams(leagueParameter)
        }

        binding.rbNbaLeague.setOnClickListener {
            leagueParameter = binding.rbNbaLeague.text.toString()
            teamListViewModel.retrieveAllTeams(leagueParameter)
        }

    }

    override fun teamClick(team: Team) {
        val intent: Intent = Intent(this, TeamDetailActivity::class.java)
        intent.putExtra(TEAM_ID, team.idTeam.toString())
        startActivity(intent)
    }
}