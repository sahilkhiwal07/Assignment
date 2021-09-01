package com.example.androidassignment.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.androidassignment.database.repository.RosterRepository
import com.example.assignment.data.Roster
import com.example.assignment.data.network.RetrofitInstance
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RosterViewModel constructor(application: Application): AndroidViewModel(application) {

    private val repository = RosterRepository(application)
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    fun getAllData(): LiveData<List<Roster>> {
        return repository.getAllData()
    }

    private fun insertAllData(roster: List<Roster>) {
        viewModelScope.launch {
            repository.insertAllData(roster)
        }
    }

    fun makeApiCall() {
        viewModelScope.launch(ioDispatcher) {
            val roster = RetrofitInstance.api.getAllData().body()
            if (roster != null) {
                this@RosterViewModel.insertAllData(roster.roster)
            }
        }
    }

}