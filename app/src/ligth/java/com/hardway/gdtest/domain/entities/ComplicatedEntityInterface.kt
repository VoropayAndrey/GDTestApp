package com.hardway.gdtest.domain.entities

import com.hardway.gdtest.domain.entities.parts.implementations.first.FirstPartImplementation1
import com.hardway.gdtest.domain.entities.parts.implementations.first.FirstPartImplementation2
import com.hardway.gdtest.domain.entities.parts.implementations.second.SecondPartImplementation1
import com.hardway.gdtest.domain.entities.parts.implementations.second.SecondPartImplementation2
import com.hardway.gdtest.domain.entities.parts.implementations.second.SecondPartImplementation3
import com.hardway.gdtest.domain.entities.parts.implementations.third.ThirdPartImplementation1
import com.hardway.gdtest.domain.entities.parts.implementations.third.ThirdPartImplementation2

/**
 * Abstract Factory Method for creating lots of ComplicatedEntityImplementations
 */
abstract class ComplicatedEntityInterface {

    abstract suspend fun doSomething(arg1: Int, arg2: Int): Boolean

    companion object {
        enum class EntityType {
            TYPE_1,
            TYPE_2,
            TYPE_3
        }

        fun getInstance(type: EntityType): ComplicatedEntityInterface {
            // Here you can easily add any implementation of your interface
            if (type == EntityType.TYPE_1) {
                return ComplicatedEntityImplementation1(FirstPartImplementation1())
            } else if (type == EntityType.TYPE_2) {
                return ComplicatedEntityImplementation2(
                    SecondPartImplementation2()
                )
            } else {
                return ComplicatedEntityImplementation1(
                    FirstPartImplementation2()
                )
            }
        }
    }
}