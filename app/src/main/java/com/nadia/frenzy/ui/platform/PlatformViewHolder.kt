package com.nadia.frenzy.ui.platform

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nadia.frenzy.R

class PlatformViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val platformPic : ImageView
    val platformName : TextView
    val platformDescription : TextView = itemView.findViewById<TextView>(R.id.platformeDescription)

    init {
        platformPic = itemView.findViewById<ImageView>(R.id.platformePic)
        platformName = itemView.findViewById<TextView>(R.id.platformeName)
    }

}