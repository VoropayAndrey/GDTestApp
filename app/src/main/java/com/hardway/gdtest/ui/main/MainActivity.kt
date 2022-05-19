package com.hardway.gdtest.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.hardway.gdtest.R
import com.hardway.gdtest.application.GDTestApp
import com.hardway.gdtest.domain.usecases.FirstInitContactsUseCase
import com.hardway.gdtest.repositories.LocalRepositoryInterface
import com.hardway.gdtest.ui.base.BaseActivity
import com.hardway.gdtest.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {


    lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
}