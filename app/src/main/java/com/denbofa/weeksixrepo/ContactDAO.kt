package com.denbofa.weeksixrepo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ContactDAO {
    @Insert
    fun addContactItem(contactItem: ContactModel)

    @Query("SELECT * from ContactModel")
    fun getAllContactItems(): LiveData<List<ContactModel>>

    @Delete
    fun delete(contactItem: ContactModel)
}