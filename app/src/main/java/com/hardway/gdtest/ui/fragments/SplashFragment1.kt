package com.hardway.gdtest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hardway.gdtest.R
import com.hardway.gdtest.ui.activities.MainActivity
import kotlinx.coroutines.*

class SplashFragment1 : Fragment() {

    lateinit var closeSplashCoroutineJob: Job

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash1, container, false)
    }

    override fun onResume() {
        super.onResume()
        closeSplashCoroutineJob = GlobalScope.launch {
            delay(2000)
            if(isActive) {
                withContext(Dispatchers.Main) {
                    (requireActivity() as MainActivity).navHostFragment.navController.navigate(
                        R.id.action_slashFragment_to_contactFragment
                    )
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        closeSplashCoroutineJob.cancel()
    }
}