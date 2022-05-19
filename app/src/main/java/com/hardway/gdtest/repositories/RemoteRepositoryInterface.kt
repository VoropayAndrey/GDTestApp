package com.hardway.gdtest.repositories

import com.hardway.gdtest.domain.entities.ContactEntity

interface RemoteRepositoryInterface {
    suspend fun requestContact(): ContactEntity
}