package com.nadia.frenzy.data.source.remote.service

import com.nadia.frenzy.data.Question
import com.nadia.frenzy.data.QuestionData
import retrofit2.Response
import retrofit2.http.*

interface QuestionService {

    @POST("questions/")
    suspend fun createNewQuestion(
        @Header("authorization") token: String,
        @Body question: QuestionData
    ): Response<String>

    @GET("questions/{id}")
    suspend fun getQuestionById(
        @Header("authorization") token: String,
        @Path("id") questionId : String
    ): Question
}