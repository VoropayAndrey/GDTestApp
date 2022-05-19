package com.hardway.gdtest.ui.start

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hardway.gdtest.R
import com.hardway.gdtest.domain.entities.ContactEntity
import kotlinx.android.synthetic.main.item_contact_list.view.*

class ContactAdapter(var items: List<ContactEntity>, val context: Activity, val onClick: (item: ContactEntity) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_contact_list,
            parent,
            false
        )

        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder: RecyclerView.ViewHolder {
    var firstName: TextView
    var lastName: TextView

    constructor(view: View) : super(view) {
        firstName = view.firstName
        lastName = view.lastName
    }

    fun bind(item: ContactEntity, onClick: (item: ContactEntity) -> Unit)  {
        firstName.text = item.firstName
        lastName.text = item.lastName
        (firstName.parent as View).setOnClickListener {
            onClick(item)
        }
    }


}