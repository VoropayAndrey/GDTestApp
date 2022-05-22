package com.hardway.gdtest.domain

import com.hardway.gdtest.domain.entities.EventEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.random.Random

class LoginEventBus {
    private val bus = MutableSharedFlow<EventEntity>()

    constructor() {

        // Let's generate some events just in demo case
        GlobalScope.launch {
            while (true) {
                delay(1000)
                bus.emit(EventEntity(Math.random() > 0.4))
            }
        }
    }

    fun listen() = bus.asSharedFlow()

    suspend fun push(event: EventEntity) {
        bus.emit(event)
    }
}