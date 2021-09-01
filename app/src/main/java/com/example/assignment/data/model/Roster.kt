package com.example.assignment.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Roster(
    @PrimaryKey
    val image_url: String,
    val name: String,
    val position: String
): Parcelable