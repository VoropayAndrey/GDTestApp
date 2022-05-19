package com.hardway.gdtest.di.components

import android.content.Context
import com.hardway.gdtest.di.modules.ContextModule
import com.hardway.gdtest.di.modules.RepositoryModule
import com.hardway.gdtest.di.modules.UseCaseModule
import com.hardway.gdtest.ui.ViewModelFactory
import com.hardway.gdtest.ui.main.MainActivity
import com.hardway.gdtest.ui.main.MainViewModel
import dagger.Component

@Component(modules = [ContextModule::class,
    RepositoryModule::class,
    UseCaseModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun getContext(): Context
    fun viewModelsFactory(): ViewModelFactory
    fun mainViewModel(): MainViewModel
}