package com.hardway.gdtest.domain.usecases

import com.hardway.gdtest.repositories.LocalRepositoryInterface
import com.hardway.gdtest.repositories.RemoteRepositoryInterface

class ResetDatabaseUseCase(private val localRepositoryInterface: LocalRepositoryInterface,
                           private val remoteRepositoryInterface: RemoteRepositoryInterface
): UseCase {
    override suspend fun invoke() {
        localRepositoryInterface.deleteAll()
        for(i in 0..50) {
            localRepositoryInterface.insert(remoteRepositoryInterface.requestContact())
        }

    }
}