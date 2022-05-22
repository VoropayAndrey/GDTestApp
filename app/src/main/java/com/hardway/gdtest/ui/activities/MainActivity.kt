package com.hardway.gdtest.ui.activities

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.hardway.gdtest.R
import com.hardway.gdtest.ui.activities.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
}