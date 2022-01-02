package com.nadia.frenzy.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nadia.frenzy.ui.game.GameAdapter
import com.nadia.frenzy.data.*
import com.nadia.frenzy.R


class GameActivity : AppCompatActivity() {

    lateinit var recylcerGame: RecyclerView
    lateinit var recylcerGameAdapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        recylcerGame = findViewById(R.id.recyclerGame)

        var gameeList : MutableList<Game> = ArrayList()

        gameeList.add(Game(gameePic = R.drawable.ic_counter_strike, gameeName = "COUNTER_STRIKE", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "HALO INFINITE", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "COUNTER_STRIKE", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "CRAB_GAME", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "DOTA2", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "APEX_LEGENDS", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "ROCKET_LEAGUE", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "PHASMOPHOBIA", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "RUST", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "AMONG_US", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "TERRARIA", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "PUBG", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "TEAM_FORTRESS", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "DESTINY2", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "NEW_WORLD", gameeDescription = "AAAA: BBBB" ))
        gameeList.add(Game(gameePic = R.drawable.ic_playstation, gameeName = "BATTLEFIELD_2042", gameeDescription = "AAAA: BBBB" ))

        recylcerGameAdapter = GameAdapter(gameeList)

        recylcerGame.adapter = recylcerGameAdapter

        recylcerGame.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

    }

}