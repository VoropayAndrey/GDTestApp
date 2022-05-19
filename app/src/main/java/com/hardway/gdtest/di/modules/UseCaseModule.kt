package com.hardway.gdtest.di.modules

import com.hardway.gdtest.domain.usecases.FirstInitContactsUseCase
import com.hardway.gdtest.domain.usecases.ResetDatabaseUseCase
import com.hardway.gdtest.repositories.LocalRepositoryInterface
import com.hardway.gdtest.repositories.RemoteRepositoryInterface
import com.hardway.gdtest.repositories.SettingsRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideResetDatabaseUseCase(localRepositoryInterface: LocalRepositoryInterface,
                                    remoteRepositoryInterface: RemoteRepositoryInterface): ResetDatabaseUseCase {
        return ResetDatabaseUseCase(localRepositoryInterface,
            remoteRepositoryInterface)
    }

    @Provides
    fun provideFirstInitContactsUseCase(settingsRepositoryInterface: SettingsRepositoryInterface,
                                    resetDatabaseUseCase: ResetDatabaseUseCase): FirstInitContactsUseCase {
        return FirstInitContactsUseCase(settingsRepositoryInterface,
            resetDatabaseUseCase)
    }
}