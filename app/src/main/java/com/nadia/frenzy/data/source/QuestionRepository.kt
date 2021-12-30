package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.Question
import com.nadia.frenzy.data.QuestionData
import retrofit2.Response
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val questionDataSource: QuestionDataSource){

    suspend fun createNewQuestion(token : String, question: QuestionData) : Result<Response<String>> {
        return questionDataSource.createNewQuestion(token, question)
    }

    suspend fun getQuestionById(token : String, questionID : String) : Result<Question> {
        return questionDataSource.getQuestionById(token, questionID)
    }
}