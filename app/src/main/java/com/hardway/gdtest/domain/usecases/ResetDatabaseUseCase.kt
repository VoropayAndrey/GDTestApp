package com.hardway.gdtest.domain.usecases

import com.hardway.gdtest.repositories.LocalRepositoryInterface
import com.hardway.gdtest.repositories.RemoteRepositoryInterface
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*


class ResetDatabaseUseCase(private val localRepositoryInterface: LocalRepositoryInterface,
                           private val remoteRepositoryInterface: RemoteRepositoryInterface
): UseCase {



    override suspend fun invoke() {
        localRepositoryInterface.deleteAll()

        coroutineScope {
            async {
                (0..10)
                    .asFlow()
                    .flatMapMerge(concurrency = 10) {
                        flowOf(generateUser(it))
                    }
                    .collect()
            }
        }
    }

    suspend fun generateUser(index: Int) {
        localRepositoryInterface.insert(remoteRepositoryInterface.requestContact())
    }
}