package com.nadia.frenzy.ui.game

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nadia.frenzy.R

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val gamePic : ImageView
    val gameName : TextView
    val gameDescription : TextView = itemView.findViewById<TextView>(R.id.gameeDescription)

    init {
        gamePic = itemView.findViewById<ImageView>(R.id.gameePic)
        gameName = itemView.findViewById<TextView>(R.id.gameeName)
    }

}