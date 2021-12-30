package com.nadia.frenzy.data.source.remote

import com.nadia.frenzy.data.Answer
import com.nadia.frenzy.data.AnswerData
import com.nadia.frenzy.data.source.AnswerDataSource
import com.nadia.frenzy.data.source.remote.service.AnswerService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class AnswerRemoteDataSource @Inject constructor (
    private val answerService: AnswerService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AnswerDataSource {

    override suspend fun getQuestionAnswer(token: String, id: String, userId: String): Result<Answer> = withContext(ioDispatcher) {
        return@withContext try {
            Result.success(answerService.getQuestionAnswer(token, id, userId))
        } catch (e : Exception) {
            Result.failure(e)
        }
    }

    override suspend fun answerOneQuestion (token: String, answerData: AnswerData): Result<Response<String>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.success(answerService.answerOneQuestion(token, answerData))
        } catch (e : Exception) {
            Result.failure(e)
        }
    }
}