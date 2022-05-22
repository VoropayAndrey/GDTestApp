package com.hardway.gdtest.ui.fragments

import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.hardway.gdtest.ui.activities.BaseActivity
import com.hardway.gdtest.ui.viewmodels.SharedViewModel

abstract class BaseFragment : Fragment() {
    protected lateinit var spinner: ProgressBar

    fun getSharedViewMode(): SharedViewModel {
        return (activity as BaseActivity).sharedViewModel
    }
}