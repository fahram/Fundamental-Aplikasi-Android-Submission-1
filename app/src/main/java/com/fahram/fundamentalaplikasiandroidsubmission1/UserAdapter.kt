package com.fahram.fundamentalaplikasiandroidsubmission1

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fahram.fundamentalaplikasiandroidsubmission1.databinding.UserItemBinding

class UserAdapter(
    private val listUsers: ArrayList<User>,
    private val onItemClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.ListUserVH>() {
    class ListUserVH(var binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserVH {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListUserVH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}