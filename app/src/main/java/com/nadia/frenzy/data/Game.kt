package com.nadia.frenzy.data

import androidx.annotation.DrawableRes

//Denotes that an integer parameter, field or method return value is expected to be a drawable resource reference

const val PICTURE = "PICTURE"
const val NAMEE = "NAMEE"
const val DESCRIPTION = "DESCRIPTION"

data class Game(

    @DrawableRes
    val gameePic: Int,

    val gameeName: String,

    val gameeDescription: String
)
