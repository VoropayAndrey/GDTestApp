package com.hardway.gdtest.repositories

import com.hardway.gdtest.domain.ContactEntity

interface RemoteRepositoryInterface {
    suspend fun requestContact(): ContactEntity
}