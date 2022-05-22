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

class SplashFragment2 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_splash2, container, false)
        view?.findViewById<Button>(R.id.openComplicatedActivity)?.setOnClickListener {
            startActivity(Intent(context, ComplicatedActivity::class.java))
        }

        return view
    }

}