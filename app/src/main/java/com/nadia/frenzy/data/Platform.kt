package com.nadia.frenzy.data

import androidx.annotation.DrawableRes

const val PICTURE2 = "PICTURE2"
const val NAME2 = "NAME2"
const val DESCRIPTION2 = "DESCRIPTION2"

data class Platform(

    @DrawableRes
    val platformePic: Int,

    val platformeName: String,

    val platformeDescription: String
)