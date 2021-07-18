package com.denbofa.weeksixrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denbofa.weeksixrepo.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.contactName.text = intent.getStringExtra("name")
        binding.contactNumber.text = intent.getStringExtra("number")
        binding.contactEmail.text = intent.getStringExtra("email")
    }
}