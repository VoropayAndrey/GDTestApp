package com.hardway.gdtest.domain.usecases

import com.hardway.gdtest.repositories.SettingsRepositoryInterface

class FirstInitContactsUseCase(private val settingsRepositoryInterface: SettingsRepositoryInterface,
                               private val resetDatabaseUseCase: ResetDatabaseUseCase): UseCase {
    override suspend fun invoke() {
        if(settingsRepositoryInterface.isFirstRun()) {
            settingsRepositoryInterface.setFirstRun(false)
            resetDatabaseUseCase.invoke()
        }
    }
}