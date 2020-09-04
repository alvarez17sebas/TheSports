package com.companytest.thesports.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.companytest.thesports.databinding.ActivityTeamListBinding
import com.companytest.thesports.model.Team
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

        teamListViewModel.retrieveAllTeams()

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
        teamListViewModel.loading.observe(this, Observer { isLoading: Boolean ->
            if(isLoading){
                Toast.makeText(this, "Cargando información de equipos....", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Carga completa", Toast.LENGTH_SHORT).show()
            }
        })

        teamListViewModel.itemsLiveData.observe(this, Observer {teams: List<Team> ->
            setRecycleData(teams)
        })
    }

    override fun teamClick(team: Team) {
        val intent: Intent = Intent(this, TeamDetailActivity::class.java)
        startActivity(intent)
    }
}