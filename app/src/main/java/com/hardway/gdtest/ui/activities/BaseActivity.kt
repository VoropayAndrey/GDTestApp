package com.hardway.gdtest.ui.activities

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.hardway.gdtest.ui.viewmodels.DetailViewModel
import com.hardway.gdtest.ui.viewmodels.SharedViewModel

abstract class BaseActivity: AppCompatActivity() {
    val sharedViewModel: SharedViewModel by viewModels()
}