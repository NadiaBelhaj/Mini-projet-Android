package com.nadia.frenzy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nadia.frenzy.R
import com.nadia.frenzy.data.User
import com.nadia.frenzy.databinding.UserListItemBinding
import com.nadia.frenzy.utils.loadImage

class PeopleAdapter : PagingDataAdapter<User, PeopleAdapter.UserViewHolder>(DIFF_CALL_BACK){

    private lateinit var onUserClickListener: (User) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = UserListItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position) ?: return
        holder.bingUser(user)
        holder.itemView.setOnClickListener {
            if (::onUserClickListener.isInitialized) {
                onUserClickListener(user)
            }
        }
    }

    fun setOnUserClickListener(listener: (User) -> Unit){
        onUserClickListener = listener
    }

    class UserViewHolder(val binding : UserListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bingUser(user : User){
            binding.usernameTxt.text = user.username
            binding.reactionsTxt.text = user.reactionsNum.toString()
            binding.userAvatar.loadImage(user.avatarUrl, R.drawable.ic_profile)
        }
    }
}

private val DIFF_CALL_BACK: DiffUtil.ItemCallback<User> =
    object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }