package com.hardway.gdtest.ui.activities

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.hardway.gdtest.R
import com.hardway.gdtest.constants.Constants
import com.hardway.gdtest.ui.activities.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment



    }

    override fun onResume() {
        super.onResume()

        intent.extras?.getInt(Constants.DESTINATION_EXTRA)?.let {
            navHostFragment.findNavController().navigate(it)
        }

    }
}