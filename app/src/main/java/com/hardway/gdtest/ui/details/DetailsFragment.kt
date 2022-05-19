package com.hardway.gdtest.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hardway.gdtest.R
import com.hardway.gdtest.application.GDTestApp
import com.hardway.gdtest.ui.base.BaseFragment
import com.hardway.gdtest.ui.viewmodels.DetailViewModel
import com.hardway.gdtest.ui.viewmodels.MainViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@AndroidEntryPoint
open class DetailsFragment : BaseFragment() {

    val detailViewModel: DetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        spinner = view.findViewById(R.id.loading_spinner)
        spinner.visibility = View.VISIBLE

        var contactId = arguments?.getInt("contact_id") ?: 0


        detailViewModel.fetchedContact.observe(viewLifecycleOwner, Observer {
            spinner.visibility = View.GONE
            view.info.text = "" + it.firstName + " " + it.lastName
        })

        detailViewModel.fetchUserById(contactId)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}