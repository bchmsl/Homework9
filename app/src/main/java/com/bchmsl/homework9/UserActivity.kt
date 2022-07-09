package com.bchmsl.homework9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import com.bchmsl.homework9.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private var userPosition = -1
    private lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)

        userPosition = intent.getIntExtra("userPosition", -1)
        if (userPosition != -1) currentUser = usersList[userPosition]

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
            if (userPosition != -1) updateUser()
            else addUser()
        }
    }

    private fun addUser() {
        if (checkFields(binding.etFirstName.text, binding.etLastName.text, binding.etEmail.text)) {
            if (Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()) {
                usersList.add(
                    User(
                        binding.etFirstName.text.toString(),
                        binding.etLastName.text.toString()
                    )
                )
                finish()
            }
        }
    }

    private fun updateUser() {
        if (checkFields(binding.etFirstName.text, binding.etLastName.text, binding.etEmail.text))
            if (Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()) {
                usersList[userPosition].apply {
                    firstName = binding.etFirstName.text.toString()
                    lastName = binding.etLastName.text.toString()
                    email = binding.etEmail.text.toString()
                }
                finish()
            }
    }

    private fun checkFields(vararg editable: Editable?): Boolean {
        editable.forEach {
            if (it.toString().isEmpty()) return false
        }
        return true
    }
}