package com.bchmsl.homework9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bchmsl.homework9.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private var userPosition = -1
    private lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)

        userPosition = intent.getIntExtra("userPosition", -1)
        currentUser = usersList[userPosition]

        setContentView(binding.root)
        init()
    }

    private fun init() {
        setUser()
        listeners()
    }


    private fun setUser() {

        if (userPosition != -1) {
            binding.etFirstName.setText(currentUser.firstName)
            binding.etLastName.setText(currentUser.lastName)
            binding.etEmail.setText(currentUser.email)
        }
    }

    private fun listeners() {
        binding.btnSave.setOnClickListener {
            usersList[userPosition].apply {
                firstName = binding.etFirstName.text.toString()
                lastName = binding.etLastName.text.toString()
                email = binding.etEmail.text.toString()
            }
            finish()
        }
    }
}