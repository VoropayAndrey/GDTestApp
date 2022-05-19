package com.hardway.gdtest.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hardway.gdtest.R
import com.hardway.gdtest.ui.base.BaseFragment
import com.hardway.gdtest.ui.details.DetailsFragment
import com.hardway.gdtest.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_start.view.*


open class StartFragment : BaseFragment() {

    private lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)

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

        getViewModel().contactsLiveData.observe(viewLifecycleOwner, Observer {
            contactAdapter.items = it
            contactAdapter.notifyDataSetChanged()
        })

        return view
    }




}