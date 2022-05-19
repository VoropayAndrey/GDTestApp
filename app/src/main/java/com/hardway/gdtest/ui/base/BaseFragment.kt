package com.hardway.gdtest.ui.base

import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.hardway.gdtest.ui.main.MainActivity
import com.hardway.gdtest.ui.viewmodels.MainViewModel

abstract class BaseFragment : Fragment() {
    protected lateinit var spinner: ProgressBar

}