package com.hardway.gdtest.domain.entities

import com.hardway.gdtest.domain.entities.parts.interfaces.SecondPartInterface
import com.hardway.gdtest.domain.entities.parts.interfaces.ThirdPartInterface

class ComplicatedEntityImplementation2(private val secondPart: SecondPartInterface):
    ComplicatedEntityInterface() {
    override suspend fun doSomething(arg1: Int, arg2: Int): Boolean {
        var array = arrayOf(1, 2, 3, 4, 5)
        return secondPart.filter(array).size > 3
    }
}