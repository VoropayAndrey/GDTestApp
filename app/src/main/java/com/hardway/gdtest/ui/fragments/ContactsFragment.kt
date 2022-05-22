package com.hardway.gdtest.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hardway.gdtest.R
import com.hardway.gdtest.constants.Constants
import com.hardway.gdtest.ui.activities.MainActivity
import com.hardway.gdtest.ui.start.ContactAdapter
import com.hardway.gdtest.ui.viewmodels.StartViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_start.view.*

@AndroidEntryPoint
open class ContactsFragment : BaseFragment() {

    private lateinit var contactAdapter: ContactAdapter

    private val startViewModel: StartViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)

        spinner = view.findViewById(R.id.loading_spinner)
        spinner.visibility = View.VISIBLE

        contactAdapter = ContactAdapter(
            listOf(),
            requireActivity()
        ) {
            var bundle = Bundle()
            bundle.putInt("contact_id", it.id)
            (requireActivity() as MainActivity).navHostFragment.navController.navigate(
                R.id.action_startFragment_to_detailsFragment,
                bundle
            )
        }

        // Creates a vertical Layout Manager
        view.contactList.layoutManager = LinearLayoutManager(context)
        view.contactList.adapter = contactAdapter

        startViewModel.contactsLiveData.observe(viewLifecycleOwner, Observer {
            contactAdapter.items = it
            spinner.visibility = View.GONE
            contactAdapter.notifyDataSetChanged()
        })

        getSharedViewMode().contactsLiveData.observe(viewLifecycleOwner, Observer {
            Log.d(Constants.TAG, "ContactsFragment, login state change, isLoggedIn: ${it.isLoggedIn}")
        })

        return view
    }




}