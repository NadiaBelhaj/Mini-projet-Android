package com.nadia.frenzy.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        gameeList.add(Game(gameePic = R.drawable.ic_counter_strike, gameeName = "COUNTER_STRIKE", gameeDescription = "Counter-Strike Online is a free multiplayer first-person shooter where terrorists and counter-terrorists are trying to kill each other using different weapons. Counter-Strike was released in 2000 and involves the fight between two opposing teams of players. Join a room full of other players, select in which team you would like to fight and start the battle. Try to lead your side to victory before the time runs out. " ))
        gameeList.add(Game(gameePic = R.drawable.ic_halo_infinite, gameeName = "HALO INFINITE", gameeDescription = "Humanity needs saving and you’re just the Spartan to save it. But whether you’re looking to be the hero your were born to be, or to carry your squad to victor in multiplayer, you’re gonna need to master the new gear in Halo: Infinite." ))
        gameeList.add(Game(gameePic = R.drawable.ic_crab_game, gameeName = "CRAB_GAME", gameeDescription = "Crab Game, is a first-person multiplayer game where the player tries to win money by participating in children's games. The concept of Crab Game is directly inspired by the popular pop Korean TV show Squid Game, where the participants have to outcompete each other in challenges, while those who fail are killed. Some of the game modes that Dani included are similar to those seen in Bean Guys" ))
        gameeList.add(Game(gameePic = R.drawable.ic_dota, gameeName = "DOTA2", gameeDescription = "Every day, millions of players worldwide enter battle as one of over a hundred Dota heroes. And no matter if it's their 10th hour of play or 1,000th, there's always something new to discover. With regular updates that ensure a constant evolution of gameplay, features, and heroes, Dota 2 has taken on a life of its own." ))
        gameeList.add(Game(gameePic = R.drawable.ic_apex_legends, gameeName = "APEX_LEGENDS", gameeDescription = "Apex Legends is the award-winning, free-to-play Hero shooter from Respawn Entertainment. Master an ever-growing roster of legendary characters with powerful abilities and experience strategic squad play and innovative gameplay in the next evolution of Hero Shooter and Battle Royale." ))
        gameeList.add(Game(gameePic = R.drawable.ic_rocket_league, gameeName = "ROCKET_LEAGUE", gameeDescription = "Rocket League is a popular spin on the generic game of soccer, where players drive cars as they crash into each other in an attempt to score the most points through goals." ))
        gameeList.add(Game(gameePic = R.drawable.ic_phasmophobia, gameeName = "PHASMOPHOBIA", gameeDescription = "Phasmophobia is a 4 player online co-op psychological horror. Paranormal activity is on the rise and it’s up to you and your team to use all the ghost hunting equipment at your disposal in order to gather as much evidence as you can." ))
        gameeList.add(Game(gameePic = R.drawable.ic_rust, gameeName = "RUST", gameeDescription = "Rust is a multiplayer survival game where you will find yourself in a post-apocalyptic world. The main task that stands before you is staying alive. You will begin the game with a minimal set of items in your inventory. And you will have to obtain other resources on your own. To avoid dying of hunger, you’ll have to hunt. And to build a house, you need to collect enough wood." ))
        gameeList.add(Game(gameePic = R.drawable.ic_among_us, gameeName = "AMONG_US", gameeDescription = "Among Us is a multiplayer escape game developed by Innersloth studio. Your goal is to identify the Impostors, eliminate them, and complete tasks around the map. And if you play as Impostors, your goal is to covertly sabotage the mission either by killing the Crewmates." ))
        gameeList.add(Game(gameePic = R.drawable.ic_terraria, gameeName = "TERRARIA", gameeDescription = "Dig, Fight, Explore, Build: The very world is at your fingertips as you fight for survival, fortune, and glory. Will you delve deep into cavernous expanses in search of treasure and raw materials with which to craft ever-evolving gear, machinery, and aesthetics? Perhaps you will choose instead to seek out ever-greater foes to test your mettle in combat? Maybe you will decide to construct your own city to house the host of mysterious allies you may encounter along your travels? In the World of Terraria, the choice is yours!" ))
        gameeList.add(Game(gameePic = R.drawable.ic_pbug, gameeName = "PUBG", gameeDescription = "Welcome to PUBG MOBILE, the official PLAYER UNKNOWN’S BATTLEGROUND’S made specially for Android and iOS! Drop onto a deserted island filled with the best gear and weapons and do whatever it takes to survive in massive battle royale matches with up to 100 players. Explore the various games, including Payload, Squad-based Battle Royale, and exciting Team Deathmatch and Zombie Modes." ))
        gameeList.add(Game(gameePic = R.drawable.ic_team_fortress, gameeName = "TEAM_FORTRESS", gameeDescription = "Team Fortress 2 is an exclusively online first person shooter. Successor of Team Fortress Classic, from which he took over the class system, he is however distinguished by a resolutely cartoon design and omnipresent humor." ))
        gameeList.add(Game(gameePic = R.drawable.ic_destiny, gameeName = "DESTINY2", gameeDescription = "Dive into the world of Destiny 2 to explore the mysteries of the solar system and experience responsive first-person shooter combat. Unlock powerful elemental abilities and collect unique gear to customize your Guardian's look and playstyle. Enjoy Destiny 2’s cinematic story, challenging co-op missions, and a variety of PvP modes alone or with friends." ))
        gameeList.add(Game(gameePic = R.drawable.ic_new_world, gameeName = "NEW_WORLD", gameeDescription = "Explore a thrilling, open-world MMO filled with danger and opportunity where you'll forge a new destiny for yourself as an adventurer shipwrecked on the supernatural island of Aeternum. Endless opportunities to fight, forage, and forge await you among the island's wilderness and ruins. Channel supernatural forces or wield deadly weapons in a classless, real-time combat system, and fight alone, with a small team, or in massed armies for PvE and PvP battles—the choices are all yours." ))
        gameeList.add(Game(gameePic = R.drawable.ic_battlefield, gameeName = "BATTLEFIELD_2042", gameeDescription = "Battlefield™ 2042 is a first-person shooter that marks the return to the iconic all-out warfare of the franchise. Adapt and overcome in a near-future world transformed by disorder. Squad up and bring a cutting-edge arsenal into dynamically-changing battlegrounds supporting 128 players, unprecedented scale, and epic destruction." ))

        recylcerGameAdapter = GameAdapter(gameeList)

        recylcerGame.adapter = recylcerGameAdapter

        recylcerGame.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

    }

}