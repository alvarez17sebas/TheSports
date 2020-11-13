package com.companytest.thesports.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.companytest.thesports.domain.Team

import com.companytest.thesports.usecases.RetrieveAllTeams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class TeamListViewModel @ViewModelInject constructor(private val retrieveAllTeams: RetrieveAllTeams) :
    ViewModel() {

    private var _teamsLiveData: MutableLiveData<List<Team>> = MutableLiveData()
    val teamsLiveData: LiveData<List<Team>> = _teamsLiveData

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun retrieveAllTeams(leagueParameter: String) {
        viewModelScope.launch {
            _loading.value = true
            retrieveAllTeams.retrieveTeams(leagueParameter).collect {
                _teamsLiveData.value = it }
        }
        _loading.value = false

    }

    /*fun retrieveAllTeams(leagueParameter: String): LiveData<List<Team>>{
            return retrieveAllTeams.retrieveTeams(leagueParameter)
            .onStart {
                _loading.value = true
            }.onCompletion {
                _loading.value = false
            }.asLiveData()
        }*/
    }