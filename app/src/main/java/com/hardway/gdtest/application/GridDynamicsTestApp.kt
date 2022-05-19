package com.hardway.gdtest.application

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GDTestApp : Application() {

    /*
    companion object {
        private lateinit var applicationComponent: ApplicationComponent
        fun getApplicationComponent() = applicationComponent
    }
     */

    override fun onCreate() {
        super.onCreate()
        /*
        applicationComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this.applicationContext))
            .build()

         */

    }
}