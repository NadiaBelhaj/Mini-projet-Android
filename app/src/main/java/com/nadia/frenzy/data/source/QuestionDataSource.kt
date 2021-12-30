package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.Question
import com.nadia.frenzy.data.QuestionData
import retrofit2.Response

interface QuestionDataSource {

    suspend fun createNewQuestion(token : String, question: QuestionData) : Result<Response<String>>

    suspend fun getQuestionById(token : String, questionID : String) : Result<Question>
}