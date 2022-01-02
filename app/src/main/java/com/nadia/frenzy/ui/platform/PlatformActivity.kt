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

        PlatformeList.add(Platform(platformePic = R.drawable.ic_playstation, platformeName = "PLAYSTATION", platformeDescription = "Playstation is a video game console developed by Sony. The first Playstation was released in 1994, followed by Playstation 2 (PS2) in 2000 and Playstation 3 (PS3) in 2006. The initial version of the console represented a significant improvement in terms of graphic quality over the existing cartridge players of the early 1990s." ))
        PlatformeList.add(Platform(platformePic = R.drawable.ic_nintendo, platformeName = "NINTENDO", platformeDescription = "Nintendo is a multinational consumer electronics and software company headquartered in Kyoto, Japan. Founded in September 1889 as a small Japanese firm producing handmade playing cards, Nintendo has evolved into one of the largest video games manufacturing companies, generating about 11 billion U.S dollars in net sales in 2019." ))
        PlatformeList.add(Platform(platformePic = R.drawable.ic_xbox, platformeName = "XBOX", platformeDescription = "Xbox is a video gaming brand created and owned by Microsoft. The brand consists of five video game consoles, as well as applications (games), streaming services, an online service by the name of Xbox network, and the development arm by the name of Xbox Game Studios. The brand was first introduced in the United States in November 2001, with the launch of the original Xbox console." ))
        PlatformeList.add(Platform(platformePic = R.drawable.ic_atari_vcs, platformeName = "ATARI_VCS", platformeDescription = "The Atari VCS differentiates itself from retro consoles with its hardware. Under the hood, the VCS has an AMD Ryzen processor and Radeon graphics. It’s also equipped with modern amenities like USB 3.0, HDMI, Wi-Fi, Bluetooth, and Ethernet. It’s essentially a budget PC that runs on a Ubuntu-based OS. Why? Well, the Atari VCS actually functions similarly as Steam Machines." ))
        PlatformeList.add(Platform(platformePic = R.drawable.ic_playdate, platformeName = "PLAYDATE", platformeDescription = "Playdate is an upcoming handheld video game console developed by Panic. It was first introduced on May 22, 2019 on the cover of Edge magazine. The Playdate name is a reference to the fact that its bundled games will be delivered on a schedule. It was designed in collaboration with Teenage Engineering, a Swedish consumer electronics company." ))


        recylcerPlatformAdapter = PlatformAdapter(PlatformeList)

        recylcerPlatform.adapter = recylcerPlatformAdapter

        recylcerPlatform.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

    }

}