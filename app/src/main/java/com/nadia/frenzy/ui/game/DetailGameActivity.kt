package com.nadia.frenzy.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.nadia.frenzy.data.*
import com.nadia.frenzy.R

class DetailGameActivity : AppCompatActivity() {

    lateinit var gamePic : ImageView
    lateinit var gameName : TextView
    lateinit var gameDescription : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_detail)


        gamePic = findViewById(R.id.gameePic)
        gameName = findViewById(R.id.gameeName)
        gameDescription = findViewById(R.id.gameeDescription)

        gamePic.setImageResource(intent.getIntExtra(PICTURE, 0))

        val name = intent.getStringExtra(NAME)
        val description = intent.getStringExtra(DESCRIPTION)

        title= "$name Detail"

        gameName.text = "Name : $name"
        gameDescription.text = "Description : $description"

    }
}