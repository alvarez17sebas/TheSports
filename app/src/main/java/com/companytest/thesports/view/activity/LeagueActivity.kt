package com.companytest.thesports.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.companytest.thesports.R
import com.companytest.thesports.databinding.ActivityLeagueBinding
import com.companytest.thesports.domain.League
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.view.LEAGUE_NAME
import com.companytest.thesports.view.adapter.LeagueAdapter
import com.companytest.thesports.view.adapter.LeagueClickListener
import com.companytest.thesports.viewmodel.LeagueViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueActivity : AppCompatActivity(), LeagueClickListener {

    private val leagueListViewModel: LeagueViewModel by viewModels()
    private lateinit var binding: ActivityLeagueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupToolbar()
        setupRecyclerView()
        leagueListViewModel.retrieveAllLeagues()
        executeObserves()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarLeague)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = getString(R.string.leagues)

    }

    private fun setupBinding() {
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupRecyclerView(){
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvLeagues.layoutManager = layoutManager
    }

    private fun setRecycleData(leagues: List<League>){
        with(binding.rvLeagues){
            adapter = LeagueAdapter(leagues, this@LeagueActivity)
        }
    }
    private fun executeObserves() {
        leagueListViewModel.lvLeague.observe(this, Observer {resultWrapper: ResultWrapper<List<League>> ->
            when(resultWrapper) {
                is ResultWrapper.Loading -> {

                }
                is ResultWrapper.Success -> {
                    setRecycleData(resultWrapper.data)
                }
                is ResultWrapper.Error -> {
                    Toast.makeText(this, resultWrapper.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun leagueClick(league: League) {
        val intent: Intent = Intent()
        intent.putExtra(LEAGUE_NAME, league.strLeague)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}