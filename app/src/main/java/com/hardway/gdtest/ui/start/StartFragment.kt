package com.hardway.gdtest.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hardway.gdtest.R
import com.hardway.gdtest.ui.base.BaseFragment
import com.hardway.gdtest.ui.details.DetailsFragment
import com.hardway.gdtest.ui.main.MainActivity
import com.hardway.gdtest.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_start.view.*

@AndroidEntryPoint
open class StartFragment : BaseFragment() {

    private lateinit var contactAdapter: ContactAdapter

    val mainViewModel: MainViewModel by viewModels()

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

        mainViewModel.contactsLiveData.observe(viewLifecycleOwner, Observer {
            contactAdapter.items = it
            spinner.visibility = View.GONE
            contactAdapter.notifyDataSetChanged()
        })

        return view
    }




}