package com.nadia.frenzy.data

//@SerializedName annotation indicates the annotated member
// should be serialized to JSON with the provided name value as its field name.

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