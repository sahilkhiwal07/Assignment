package com.example.androidassignment.database.repository

import android.app.Application
import com.example.androidassignment.database.dao.RosterDao
import com.example.androidassignment.database.db.RosterDatabase
import com.example.assignment.data.Roster

class RosterRepository(application: Application) {
    private val rosterDao: RosterDao

    init {
        val db = RosterDatabase.getDatabase(application)
        rosterDao = db.rosterDao()
    }

    suspend fun insertAllData(roster: List<Roster>) = rosterDao.insertAllData(roster)

    fun getAllData() = rosterDao.getAllData()
}