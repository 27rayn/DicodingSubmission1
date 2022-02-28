package com.example.githubusersubmission1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusersubmission1.databinding.ItemRowUserBinding

class ListUserAdapter(private val listuser: ArrayList<GithubUser>) :
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GithubUser)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding =
            ItemRowUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listuser[position]
        holder.binding.tvName.text = item.name
        holder.binding.tvUsername.text = item.username
        holder.binding.imgUserPhoto.setImageResource(item.avatar)
        holder.binding.tvLocation.text = item.location
        holder.binding.tvCompany.text = item.company
        holder.binding.tvFollowing.text = item.following
        holder.binding.tvFollowers.text = item.followers
        holder.binding.tvRepository.text = item.repository

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listuser[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listuser.size

    class ListViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}