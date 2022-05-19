package com.hardway.gdtest.repositories

import com.hardway.gdtest.domain.entities.ContactEntity

interface LocalRepositoryInterface {
    suspend fun insert(vararg contact: ContactEntity)
    suspend fun getAll(): List<ContactEntity>
    suspend fun deleteAll()
    suspend fun getById(id: Int): ContactEntity
}