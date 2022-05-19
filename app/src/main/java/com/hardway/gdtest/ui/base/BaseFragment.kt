package com.hardway.gdtest.ui.base

import androidx.fragment.app.Fragment
import com.hardway.gdtest.extensions.getAppComponent
import androidx.fragment.app.viewModels
import com.hardway.gdtest.ui.main.MainActivity
import com.hardway.gdtest.ui.main.MainViewModel

abstract class BaseFragment : Fragment() {


    fun getViewModel(): MainViewModel {
        return (requireActivity() as MainActivity).viewModel
    }
}