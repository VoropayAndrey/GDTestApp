package com.hardway.gdtest.di.modules

import com.hardway.gdtest.domain.LoginEventBus
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class EventBusModule {
    @Provides
    fun provideEventBus() = LoginEventBus()
}