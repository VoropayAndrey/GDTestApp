package com.hardway.gdtest.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
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

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}