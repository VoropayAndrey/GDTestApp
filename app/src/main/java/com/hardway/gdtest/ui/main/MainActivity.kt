package com.hardway.gdtest.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.hardway.gdtest.R
import com.hardway.gdtest.application.GridDynamicsTestApp
import com.hardway.gdtest.domain.usecases.FirstInitContactsUseCase
import com.hardway.gdtest.extensions.getAppComponent
import com.hardway.gdtest.repositories.LocalRepositoryInterface
import com.hardway.gdtest.repositories.RemoteRepositoryInterface
import com.hardway.gdtest.ui.base.BaseActivity
import com.hardway.gdtest.ui.start.StartFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var localRepository: LocalRepositoryInterface

    @Inject
    lateinit var firstInitContactsUseCase: FirstInitContactsUseCase

    lateinit var navHostFragment: NavHostFragment

    val viewModel: MainViewModel by viewModels {
        GridDynamicsTestApp.getApplicationComponent().viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GridDynamicsTestApp.getApplicationComponent().inject(this)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
}