package com.denbofa.weeksixrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denbofa.weeksixrepo.databinding.ContactListItemBinding

class ContactAdapter(val contactItems: List<ContactModel>, val clickerFunc: (ContactModel)-> Unit): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    inner class  ViewHolder(val binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(contactItem: ContactModel){
            binding.userName.text = contactItem.userFullName
            binding.userNumber.text = contactItem.userPhoneNumber
            binding.root.setOnClickListener {
                clickerFunc(contactItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ContactListItemBinding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun getItemCount() = contactItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactItems.get(position))
    }
}