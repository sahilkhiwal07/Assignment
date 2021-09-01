package com.example.androidassignment.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment.data.Roster

@Dao
interface RosterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllData(roster: List<Roster>)

    @Query("select * from Roster")
    fun getAllData(): LiveData<List<Roster>>

}