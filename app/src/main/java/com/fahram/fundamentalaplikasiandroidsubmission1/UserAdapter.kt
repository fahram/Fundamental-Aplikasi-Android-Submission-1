package com.fahram.fundamentalaplikasiandroidsubmission1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fahram.fundamentalaplikasiandroidsubmission1.databinding.UserItemBinding

class UserAdapter(
    private val listUsers: ArrayList<User>,
    private val onItemClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.ListUserVH>() {
    class ListUserVH(var binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserVH {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListUserVH(binding)
    }

    override fun onBindViewHolder(holder: ListUserVH, position: Int) {
        val (username, name, avatar) = listUsers[position]
        holder.binding.ivAvatarItem.setImageResource(avatar)
        holder.binding.tvUsernameItem.text = username
        holder.binding.tvNameItem.text = name
        holder.itemView.setOnClickListener {
            onItemClick(listUsers[position])
        }
    }

    override fun getItemCount(): Int = listUsers.size
}