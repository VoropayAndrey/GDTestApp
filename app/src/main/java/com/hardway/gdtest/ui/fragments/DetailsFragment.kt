package com.hardway.gdtest.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hardway.gdtest.R
import com.hardway.gdtest.constants.Constants
import com.hardway.gdtest.ui.fragments.BaseFragment
import com.hardway.gdtest.ui.viewmodels.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_details.view.*

@AndroidEntryPoint
open class DetailsFragment : BaseFragment() {

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        view.loading_spinner.visibility = View.VISIBLE

        var contactId = arguments?.getInt("contact_id") ?: 0

        detailViewModel.fetchedContact.observe(viewLifecycleOwner, Observer {
            Glide.with(this)
                .load(it.photoURL)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(view.contact_photo)
            view.contact_first_name.setText(it.firstName)
            view.contact_last_name.setText(it.lastName)
            view.contact_phone_number_1.setText(it.phone1)
            view.contact_phone_number_2.setText(it.phone2)
            view.loading_spinner.visibility = View.GONE
        })

        detailViewModel.fetchUserById(contactId)

        getSharedViewMode().contactsLiveData.observe(viewLifecycleOwner, Observer {
            Log.d(Constants.TAG, "DetailsFragment, login state change, isLoggedIn: ${it.isLoggedIn}")
        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}