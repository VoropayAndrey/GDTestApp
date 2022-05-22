package com.hardway.gdtest.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.hardway.gdtest.R
import com.hardway.gdtest.ui.activities.ComplicatedActivity
import com.hardway.gdtest.ui.activities.MainActivity
import com.hardway.gdtest.ui.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_slash.view.*
import kotlinx.coroutines.*

class SlashBaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_slash, container, false)

        var fragmentList = arrayListOf(
            SplashFragment1(),
            SplashFragment2()
        )

        var adapter = ViewPagerAdapter(fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle)

        view.viewPager.adapter = adapter

        return view
    }

    override fun onResume() {
        super.onResume()

    }
}