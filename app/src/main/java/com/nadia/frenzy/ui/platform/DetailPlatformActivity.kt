package com.nadia.frenzy.ui.platform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.nadia.frenzy.data.*
import com.nadia.frenzy.R

class DetailPlatformActivity : AppCompatActivity() {

    lateinit var platformPic : ImageView
    lateinit var platformName : TextView
    lateinit var platformDescription : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platform_detail)


        platformPic = findViewById(R.id.platformePic)
        platformName = findViewById(R.id.platformeName)
        platformDescription = findViewById(R.id.platformeDescription)

        platformPic.setImageResource(intent.getIntExtra(PICTURE2, 0))

        val name = intent.getStringExtra(NAME2)
        val description = intent.getStringExtra(DESCRIPTION2)

        title= "$name Detail"

        platformName.text = "Name : $name"
        platformDescription.text = "Role : $description"

    }
}