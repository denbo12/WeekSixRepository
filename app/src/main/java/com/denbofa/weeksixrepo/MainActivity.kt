package com.denbofa.weeksixrepo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.denbofa.weeksixrepo.databinding.ActivityMainBinding
import com.denbofa.weeksixrepo.databinding.ContactListItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    private lateinit var myContactList: MutableList<ContactModel>
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        myContactList = mutableListOf()

        myContactAdapter = ContactAdapter(myContactList){
            val intent = Intent(this, ContactDetailsActivity::class.java)
            intent.putExtra("name", it.userFullName)
            intent.putExtra("number", it.userPhoneNumber)
            intent.putExtra("email", it.userEmail)
            startActivity(intent)
        }
        binding.recyclerView.adapter = myContactAdapter

        val  db = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "contact-database"
        ).allowMainThreadQueries().build()

        viewModel.getAllContactItems(db).observe(this, Observer<List<ContactModel>> {
            myContactAdapter = ContactAdapter(it){}
            binding.recyclerView.adapter = myContactAdapter
            myContactAdapter.notifyDataSetChanged()
        })


        binding.button.setOnClickListener {
            val name: String = binding.contactName.text.toString()
            val number: String = binding.contactNumber.text.toString()
            val email: String = binding.contactEmail.text.toString()

            val contactItem = ContactModel(name, number, email)
            viewModel.addContactItem(contactItem, db)
            myContactAdapter.notifyDataSetChanged()
        }

    }
}