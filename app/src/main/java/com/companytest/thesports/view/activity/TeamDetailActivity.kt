package com.companytest.thesports.view.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.companytest.thesports.R
import com.companytest.thesports.databinding.ActivityTeamDetailBinding
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team
import com.companytest.thesports.view.TEAM_ID
import com.companytest.thesports.view.adapter.EventAdapter
import com.companytest.thesports.viewmodel.TeamDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamDetailActivity : AppCompatActivity() {

    private val teamDetailViewModel: TeamDetailViewModel by viewModels()
    private lateinit var teamId: String
    private lateinit var binding: ActivityTeamDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupDataBinding()

        setupToolbar()

        receiveTeamId()

        teamDetailViewModel.retrieveTeam(teamId)
        teamDetailViewModel.retrieveNextEventsByTeamId(teamId)

        setupEventRecyclerView()

        executeObservers()
    }

    private fun receiveTeamId() {
        teamId = intent.getStringExtra(TEAM_ID)!!
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    private fun setupDataBinding() {
        binding = ActivityTeamDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupEventRecyclerView() {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTeamEvents.layoutManager = layoutManager
    }

    private fun setRecyclerEventData(events: List<Event>) {
        with(binding.rvTeamEvents) {
            adapter = EventAdapter(events)
        }
    }

    private fun executeObservers() {
        teamDetailViewModel.teamLiveData.observe(this, Observer { team: Team ->
            supportActionBar?.title = (team.strTeam)
            binding.tvTeamFoundationYear.text = team.intFormedYear
            binding.tvDescriptionTeamDetail.text = team.strDescriptionEN
            loadImage(team.strTeamBadge, binding.ivCoverPhoto)
            loadImage(team.strTeamJersey, binding.ivJersey)

            clickEvents(team)
        })

        teamDetailViewModel.eventsLiveData.observe(this, Observer { events: List<Event> ->
            setRecyclerEventData(events)
        })

        teamDetailViewModel.loading.observe(this, Observer { isLoading: Boolean ->
            if (isLoading) binding.clLoadingContainer.visibility =
                View.VISIBLE else binding.clLoadingContainer.visibility = View.GONE
        })
    }

    private fun redirectToWebPage(strUrlPage: String) {
        val uri: Uri = Uri.parse("http://$strUrlPage")
        val intent: Intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun clickEvents(team: Team) {
        binding.ivYoutube.setOnClickListener {
            if (team.strYoutube != "") redirectToWebPage(team.strYoutube) else showToast()
        }

        binding.ivFacebook.setOnClickListener {
            if (team.strFacebook != "") redirectToWebPage(team.strFacebook) else showToast()
        }

        binding.ivInstagram.setOnClickListener {
            if (team.strInstagram != "") redirectToWebPage(team.strInstagram) else showToast()
        }

        binding.ivTwitter.setOnClickListener {
            if (team.strTwitter != "") redirectToWebPage(team.strTwitter) else showToast()
        }

        binding.ivWeb.setOnClickListener {
            if (team.strWebsite != "") redirectToWebPage(team.strWebsite) else showToast()
        }
    }

    private fun showToast() {
        var toast = Toast.makeText(
            this,
            getString(R.string.no_url),
            Toast.LENGTH_SHORT
        )
        toast.show()
    }

    private fun loadImage(strUrlImage: String, imageView: ImageView) {
        Glide.with(this).load(strUrlImage)
            .placeholder(R.drawable.broken_image).into(imageView)
    }
}