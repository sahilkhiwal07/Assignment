package com.example.androidassignment.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidassignment.database.dao.RosterDao
import com.example.assignment.data.Roster

@Database(entities = [Roster::class], version = 1)
abstract class RosterDatabase: RoomDatabase() {
    abstract fun rosterDao(): RosterDao

    companion object {
        private var instance: RosterDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RosterDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                RosterDatabase::class.java, "roster_database")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }

}