package com.shubhamkumarwinner.retrofitmvvm.information

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shubhamkumarwinner.retrofitmvvm.databinding.UserItemBinding
import com.shubhamkumarwinner.retrofitmvvm.network.User

class InformationAdapter(private val onClickListener: OnClickListener): ListAdapter<User, InformationAdapter.InformationViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationViewHolder {
        return InformationViewHolder(UserItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: InformationViewHolder, position: Int) {
        val user = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(user)
        }
        holder.bind(user)
    }

    //viewHolder class
    class InformationViewHolder(private var binding: UserItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.user = user
            binding.executePendingBindings()
        }
    }

    //diffCallback class
    companion object DiffCallback: DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class OnClickListener(val clickListener: (user: User) -> Unit) {
        fun onClick(user: User) = clickListener(user)
    }
}