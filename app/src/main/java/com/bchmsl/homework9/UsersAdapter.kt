package com.bchmsl.homework9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework9.databinding.LayoutUserBinding


typealias onEditClick = (position: Int) -> Unit
typealias onRemoveClick = (user: User) -> Unit

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    lateinit var itemEditClick: onEditClick
    lateinit var itemRemoveClick: onRemoveClick

    inner class UsersViewHolder(val binding: LayoutUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder =
        UsersViewHolder(LayoutUserBinding.inflate(LayoutInflater.from(parent.context)))


    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val currentItem = usersList[position]
        holder.binding.apply {
            tvFirstNameValue.text = currentItem.firstName
            tvLastNameValue.text = currentItem.lastName
            tvEmailValue.text = currentItem.email
        }
        holder.binding.btnEdit.setOnClickListener { itemEditClick(position) }
        holder.binding.btnRemove.setOnClickListener { itemRemoveClick(currentItem) }
    }

    override fun getItemCount(): Int = usersList.size


}