package com.hardway.gdtest.application

import android.app.Application
import com.hardway.gdtest.di.components.ApplicationComponent
import com.hardway.gdtest.di.components.DaggerApplicationComponent
import com.hardway.gdtest.di.modules.ContextModule

class GridDynamicsTestApp : Application() {

    companion object {
        private lateinit var applicationComponent: ApplicationComponent
        fun getApplicationComponent() = applicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this.applicationContext))
            .build()

    }
}