package com.nadia.frenzy.ui.platform

import android.view.View
import android.widget.ArrayAdapter
import androidx.annotation.NonNull
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nadia.frenzy.ui.platform.DetailPlatformActivity
import com.nadia.frenzy.R
import com.nadia.frenzy.data.*

class PlatformAdapter(val platformsList: MutableList<Platform>) : RecyclerView.Adapter<PlatformViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatformViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.platform_single_item, parent, false)

        return PlatformViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlatformViewHolder, position: Int) {

        val name = platformsList[position].platformeName
        val description = platformsList[position].platformeDescription

        holder.platformPic.setImageResource(platformsList[position].platformePic)
        holder.platformName.text = name
        holder.platformDescription.text = description

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailPlatformActivity::class.java)
            intent.apply {
                putExtra(PICTURE2, platformsList[position].platformePic)
                putExtra(NAME2, name)
                putExtra(DESCRIPTION2, description)
            }
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount() = platformsList.size

}