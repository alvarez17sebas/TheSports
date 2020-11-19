package com.companytest.thesports.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team

import com.companytest.thesports.usecases.RetrieveAllTeams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TeamListViewModel @ViewModelInject constructor(private val retrieveAllTeams: RetrieveAllTeams) :
    ViewModel() {

    private var _lvTeams: MutableLiveData<ResultWrapper<List<Team>>> = MutableLiveData()
    var lvTeams: LiveData<ResultWrapper<List<Team>>> = _lvTeams

    fun getTeams(leagueParameter: String) {
        viewModelScope.launch {
            retrieveAllTeams.retrieveTeams(leagueParameter).collect {
                _lvTeams.value = it
            }
        }
    }
}