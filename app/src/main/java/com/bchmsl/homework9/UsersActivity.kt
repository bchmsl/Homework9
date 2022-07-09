package com.bchmsl.homework9

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.bchmsl.homework9.databinding.ActivityUsersBinding

class UsersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUsersBinding

    private var adapter = UsersAdapter()
    private var position = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    private fun init() {
        setupRecycler()
        buttonListeners()
    }

    private fun setupRecycler() {
        binding.rvUsers.adapter = adapter
        binding.rvUsers.apply {
            layoutManager =
                LinearLayoutManager(this@UsersActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun buttonListeners() {
        adapter.itemEditClick = { position ->
            editUser(position)
        }
        adapter.itemRemoveClick = { user ->
            usersList.remove(user)
            adapter.notifyDataSetChanged()
        }
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }
    }

    private fun editUser(position: Int) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra("userPosition", position)
        this.position = position
        startActivity(intent)
    }
}