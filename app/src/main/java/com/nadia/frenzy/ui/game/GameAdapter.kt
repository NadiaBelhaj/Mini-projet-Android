package com.nadia.frenzy.ui.game

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nadia.frenzy.R
import com.nadia.frenzy.data.*


class GameAdapter(val gamesList: MutableList<Game>) : RecyclerView.Adapter<GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.game_single_item, parent, false)

        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {

        val name = gamesList[position].gameeName
        val description = gamesList[position].gameeDescription

        holder.gamePic.setImageResource(gamesList[position].gameePic)
        holder.gameName.text = name
        holder.gameDescription.text = description

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailGameActivity::class.java)
            intent.apply {
                putExtra(PICTURE, gamesList[position].gameePic)
                putExtra(NAMEE, name)
                putExtra(DESCRIPTION, description)
            }
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount() = gamesList.size

}