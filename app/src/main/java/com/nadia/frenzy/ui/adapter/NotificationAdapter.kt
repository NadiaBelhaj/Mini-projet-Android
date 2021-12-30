package com.nadia.frenzy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nadia.frenzy.R
import com.nadia.frenzy.data.Action
import com.nadia.frenzy.data.Notification
import com.nadia.frenzy.data.Open
import com.nadia.frenzy.databinding.NotificationListItemBinding
import com.nadia.frenzy.utils.backgroundColor
import com.nadia.frenzy.utils.setFormattedDateForPost

class NotificationAdapter : PagingDataAdapter<Notification, NotificationAdapter.NotificationViewHolder>(DIFF_CALL_BACK) {

    private lateinit var onItemClickListener : (Notification) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = NotificationListItemBinding.inflate(inflater, parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val currentNotification = getItem(position) ?: return
        holder.bingNotification(currentNotification)
        if(::onItemClickListener.isInitialized){
            holder.itemView.setOnClickListener {
                onItemClickListener(currentNotification)
            }
        }
    }

    fun setOnItemClickListener(listener: (Notification) -> Unit){
        onItemClickListener = listener
    }

    class NotificationViewHolder(val binding : NotificationListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bingNotification(notification: Notification) {
            binding.notificationBody.text = notification.body
            binding.notificationDate.setFormattedDateForPost(notification.createdDate)

            when(notification.action){
                Action.QUESTION -> binding.notificationIcon.setImageResource(R.drawable.ic_questions)
                Action.ANSWER -> binding.notificationIcon.setImageResource(R.drawable.ic_answers)
                Action.FOLLOW -> binding.notificationIcon.setImageResource(R.drawable.ic_followers)
            }

            if(notification.isOpened == Open.UN_OPENED){
                binding.notificationCardView.backgroundColor(itemView.context, R.color.white)
            }
        }
    }
}

private val DIFF_CALL_BACK: DiffUtil.ItemCallback<Notification> =
    object : DiffUtil.ItemCallback<Notification>() {
        override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean {
            return oldItem == newItem
        }
    }