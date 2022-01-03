package com.nadia.frenzy.data

import com.google.gson.annotations.SerializedName

enum class Action{
    @SerializedName("normal")
    NORMAL,

    @SerializedName("follow")
    FOLLOW,

    @SerializedName("question")
    QUESTION,

    @SerializedName("answer")
    ANSWER
}