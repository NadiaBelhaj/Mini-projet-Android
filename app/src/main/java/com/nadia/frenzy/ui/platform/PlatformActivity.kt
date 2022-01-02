package com.nadia.frenzy.ui.platform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nadia.frenzy.ui.platform.PlatformAdapter
import com.nadia.frenzy.data.*
import com.nadia.frenzy.R

class PlatformActivity : AppCompatActivity() {

    lateinit var recylcerPlatform: RecyclerView
    lateinit var recylcerPlatformAdapter: PlatformAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platform)

        recylcerPlatform = findViewById(R.id.recyclerPlatform)

        var PlatformeList : MutableList<Platform> = ArrayList()

        PlatformeList.add(Platform(platformePic = R.drawable.ic_playstation, platformeName = "PLAYSTATION", platformeDescription = "AAAA: BBBB" ))
        PlatformeList.add(Platform(platformePic = R.drawable.ic_counter_strike, platformeName = "NINTENDO", platformeDescription = "AAAA: BBBB" ))
        PlatformeList.add(Platform(platformePic = R.drawable.ic_counter_strike, platformeName = "XBOX", platformeDescription = "AAAA: BBBB" ))
        PlatformeList.add(Platform(platformePic = R.drawable.ic_counter_strike, platformeName = "ATARI_VCS", platformeDescription = "AAAA: BBBB" ))
        PlatformeList.add(Platform(platformePic = R.drawable.ic_counter_strike, platformeName = "POLYMEGA", platformeDescription = "AAAA: BBBB" ))
        PlatformeList.add(Platform(platformePic = R.drawable.ic_counter_strike, platformeName = "PLAYDATE", platformeDescription = "AAAA: BBBB" ))


        recylcerPlatformAdapter = PlatformAdapter(PlatformeList)

        recylcerPlatform.adapter = recylcerPlatformAdapter

        recylcerPlatform.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

    }

}