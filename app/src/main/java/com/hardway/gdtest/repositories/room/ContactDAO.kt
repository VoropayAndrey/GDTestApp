package com.hardway.gdtest.repositories.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM contact WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Contact>

    @Query("SELECT * FROM contact WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Contact

    @Insert
    fun insertAll(vararg users: Contact)

    @Delete
    fun delete(user: Contact)

    @Query("DELETE FROM contact")
    fun deleteAll()

}