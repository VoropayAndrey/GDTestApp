package com.hardway.gdtest.domain.usecases

import androidx.lifecycle.ViewModel
import com.hardway.gdtest.domain.entities.ComplicatedEntityInterface
import dagger.hilt.android.lifecycle.HiltViewModel

class ComplicatedUseCase: UseCase {
    override suspend fun invoke(): Boolean {
        var complicatedEntity = ComplicatedEntityInterface.getInstance(ComplicatedEntityInterface.Companion.EntityType.TYPE_3)
        return complicatedEntity.doSomething(0, 1)
    }
}