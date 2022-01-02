package com.nadia.frenzy.data

import androidx.annotation.DrawableRes

const val PICTURE = "PICTURE"
const val NAMEE = "NAMEE"
const val DESCRIPTION = "DESCRIPTION"

data class Game(

    @DrawableRes
    val gameePic: Int,

    val gameeName: String,

    val gameeDescription: String
)