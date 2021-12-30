package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.Answer
import com.nadia.frenzy.data.AnswerData
import retrofit2.Response
import javax.inject.Inject

class AnswerRepository @Inject constructor(private val answerDataSource: AnswerDataSource) {

    suspend fun getQuestionAnswer(token : String, id : String, userId : String) : Result<Answer> {
        return answerDataSource.getQuestionAnswer(token, id, userId)
    }

    suspend fun answerOneQuestion(token : String, answerData: AnswerData) : Result<Response<String>> {
        return answerDataSource.answerOneQuestion(token, answerData)
    }
}