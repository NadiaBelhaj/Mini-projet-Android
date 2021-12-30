package com.nadia.frenzy.data.source.remote

import com.nadia.frenzy.data.Question
import com.nadia.frenzy.data.QuestionData
import com.nadia.frenzy.data.source.QuestionDataSource
import com.nadia.frenzy.data.source.remote.service.QuestionService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuestionRemoteDataSource @Inject constructor (
    private val questionService: QuestionService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : QuestionDataSource {

    override suspend fun createNewQuestion(token: String, question: QuestionData): Result<Response<String>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.success(questionService.createNewQuestion(token, question))
        } catch (e : Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getQuestionById(token: String, questionID: String): Result<Question> = withContext(ioDispatcher) {
        return@withContext try {
            Result.success(questionService.getQuestionById(token, questionID))
        } catch (e : Exception) {
            Result.failure(e)
        }
    }
}