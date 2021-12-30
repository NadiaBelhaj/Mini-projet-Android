package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.ReactionData
import retrofit2.Response

interface ReactionDataSource {

    suspend fun createAnswerReaction(token : String, reactionData: ReactionData) : Result<Response<String>>

    suspend fun deleteAnswerReaction(token : String, reactionData: ReactionData) : Result<Response<String>>
}