package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.Answer
import com.nadia.frenzy.data.AnswerData
import retrofit2.Response

interface AnswerDataSource {

    suspend fun getQuestionAnswer(token : String, id : String, userId : String) : Result<Answer>

    suspend fun answerOneQuestion(token : String, answerData: AnswerData) : Result<Response<String>>
}