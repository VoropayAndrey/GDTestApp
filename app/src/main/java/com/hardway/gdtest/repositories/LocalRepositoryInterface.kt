package com.hardway.gdtest.repositories

import com.hardway.gdtest.domain.ContactEntity

interface LocalRepositoryInterface {
    suspend fun insert(vararg contact: ContactEntity)
    suspend fun getAll(): List<ContactEntity>
    suspend fun deleteAll()
}