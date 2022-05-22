package com.hardway.gdtest.domain.entities

import com.hardway.gdtest.domain.entities.parts.implementations.second.SecondPartImplementation3
import com.hardway.gdtest.domain.entities.parts.interfaces.FirstPartInterface
import com.hardway.gdtest.domain.entities.parts.interfaces.SecondPartInterface
import com.hardway.gdtest.domain.entities.parts.interfaces.ThirdPartInterface

class ComplicatedEntityImplementation1(private val firstPart: FirstPartInterface): ComplicatedEntityInterface() {
    override suspend fun doSomething(arg1: Int, arg2: Int): Boolean {
        firstPart.invoke()
        return true
    }
}