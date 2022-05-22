package com.hardway.gdtest.domain.entities

import com.hardway.gdtest.domain.entities.parts.implementations.second.SecondPartImplementation3
import com.hardway.gdtest.domain.entities.parts.interfaces.FirstPartInterface
import com.hardway.gdtest.domain.entities.parts.interfaces.SecondPartInterface
import com.hardway.gdtest.domain.entities.parts.interfaces.ThirdPartInterface

class ComplicatedEntityImplementation1(private val firstPart: FirstPartInterface,
                                       private var secondPart: SecondPartInterface,
                                       private val thirdPart: ThirdPartInterface): ComplicatedEntityInterface() {
    override suspend fun doSomething(arg1: Int, arg2: Int): Boolean {
        var array = arrayOf(1, 2, 3, 4, 5)
        if(array.contains(3)) {
            // Switch implementation of the go if needed
            secondPart = SecondPartImplementation3()
        }
        firstPart.invoke()
        return thirdPart.check(secondPart.filter(array))
    }
}