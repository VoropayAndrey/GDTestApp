package com.hardway.gdtest.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import com.google.android.material.navigation.NavigationView
import com.hardway.gdtest.R
import com.hardway.gdtest.constants.Constants
import com.hardway.gdtest.ui.viewmodels.DetailViewModel
import com.hardway.gdtest.ui.viewmodels.SharedViewModel

abstract class BaseActivity: AppCompatActivity() {

    val sharedViewModel: SharedViewModel by viewModels()
    protected lateinit var toolbar: Toolbar
    protected lateinit var drawer: DrawerLayout
    protected lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    protected fun initToolbar() {
        toolbar = findViewById(R.id.appToolbar)
        drawer = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        navigationView.setNavigationItemSelectedListener {
           return@setNavigationItemSelectedListener when(it.itemId) {
               R.id.startScreenMenuItem -> {
                   drawer.closeDrawer(GravityCompat.START)
                   startActivity(Intent(baseContext, MainActivity::class.java).apply {
                       putExtra(Constants.DESTINATION_EXTRA, R.id.slashFragment)
                       flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                   })
                   true
               }
               R.id.contactListMenuItem -> {
                   drawer.closeDrawer(GravityCompat.START)
                   startActivity(Intent(baseContext, MainActivity::class.java).apply {
                       putExtra(Constants.DESTINATION_EXTRA, R.id.contactsFragment)
                       flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                   })
                   true
               }
               R.id.complicatedActivityMenuItem -> {
                   drawer.closeDrawer(GravityCompat.START)
                   startActivity(Intent(baseContext, ComplicatedActivity::class.java).apply {
                       flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                   })
                   true
               }
               else -> false
           }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when(item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> false
        }
    }
}