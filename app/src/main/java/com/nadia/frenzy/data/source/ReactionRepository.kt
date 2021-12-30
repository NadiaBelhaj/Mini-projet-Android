package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.ReactionData
import retrofit2.Response
import javax.inject.Inject

class ReactionRepository @Inject constructor(private val reactionDataSource: ReactionDataSource) {

    suspend fun createAnswerReaction(token : String, reactionData: ReactionData) : Result<Response<String>> {
        return reactionDataSource.createAnswerReaction(token, reactionData)
    }

    suspend fun deleteAnswerReaction(token : String, reactionData: ReactionData) : Result<Response<String>> {
        return reactionDataSource.deleteAnswerReaction(token, reactionData)
    }
}