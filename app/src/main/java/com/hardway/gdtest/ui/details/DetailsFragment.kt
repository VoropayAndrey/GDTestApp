package com.hardway.gdtest.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hardway.gdtest.R
import com.hardway.gdtest.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


open class DetailsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        var contactId = arguments?.getInt("contact_id")

        GlobalScope.launch {
            

        }

        view.info.text = "Details"

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}