package com.companytest.thesports.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team
import com.companytest.thesports.usecases.RetrieveAllEventsByTeamId
import com.companytest.thesports.usecases.RetrieveTeam
import kotlinx.coroutines.launch

class TeamDetailViewModel @ViewModelInject constructor(private val retrieveTeam: RetrieveTeam, private val retrieveAllEventsByTeamId: RetrieveAllEventsByTeamId) : ViewModel() {

    private var _teamLiveData: MutableLiveData<Team> = MutableLiveData()
    var teamLiveData: LiveData<Team> = _teamLiveData

    private var _eventsLiveData: MutableLiveData<List<Event>> = MutableLiveData()
    var eventsLiveData: LiveData<List<Event>> = _eventsLiveData

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun retrieveTeam(idTeam: String){
        viewModelScope.launch {
            var response: Team? = null
            _loading.value = true
            response = retrieveTeam.retrieveTeam(idTeam)
            _loading.value = false
            _teamLiveData.value = response
        }
    }

    fun retrieveNextEventsByTeamId(teamId: String){
        viewModelScope.launch {
            var response: List<Event> = arrayListOf()
            _loading.value = true
            response = retrieveAllEventsByTeamId.retrieveEventsByTeamId(teamId)
            _eventsLiveData.value = response ?: arrayListOf()
        }
    }
}