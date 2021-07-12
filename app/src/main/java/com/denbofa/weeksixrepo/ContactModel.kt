package com.denbofa.weeksixrepo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactModel (
    val userFullName: String,
    val userPhoneNumber: String,
    val userEmail: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0

)