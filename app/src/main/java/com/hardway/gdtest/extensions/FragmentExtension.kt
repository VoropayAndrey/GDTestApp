package com.hardway.gdtest.extensions

import androidx.fragment.app.Fragment
import com.hardway.gdtest.application.GridDynamicsTestApp
import com.hardway.gdtest.di.components.ApplicationComponent

fun Fragment.getAppComponent(): ApplicationComponent = GridDynamicsTestApp.getApplicationComponent()


