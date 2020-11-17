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

    /*private var _teamsLiveData: MutableLiveData<List<Team>> = MutableLiveData()
    val teamsLiveData: LiveData<List<Team>> = _teamsLiveData

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun retrieveAllTeams(leagueParameter: String) {
        viewModelScope.launch {
            _loading.value = true
            retrieveAllTeams.retrieveTeams(leagueParameter).collect {
                _teamsLiveData.value = it
            }
        }
        _loading.value = false

    }*/


    private var _lvTeams: MutableLiveData<ResultWrapper<List<Team>>> = MutableLiveData()
    var lvTeams: LiveData<ResultWrapper<List<Team>>> = _lvTeams

    fun getTeams(leagueParameter: String) {

        /*lvTeams = retrieveAllTeams.retrieveTeams(leagueParameter)
            .onStart {
                emit(ResultWrapper.Loading)
            }.catch {
                emit(ResultWrapper.Error("Not Internet"))}.flowOn(Dispatchers.IO)
            .asLiveData()*/


        viewModelScope.launch {
            retrieveAllTeams.retrieveTeams(leagueParameter).collect {
                _lvTeams.value = it
            }
        }
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