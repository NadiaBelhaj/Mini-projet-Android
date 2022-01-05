package com.nadia.frenzy.data.source.remote


// Coroutines are programs that allow for cooperative multitasking.
//coroutine has an associated CoroutineContext, which is an indexed set of Elements.
/*CoroutineDispatcher it is responsible for determining the execution thread (or threads) of the coroutine.
When Kotlin executes a coroutine, it first checks if CoroutineDispatcher#isDispatchNeeded returns true or not.
If yes, then CoroutineDispatcher#dispatchassigns the execution thread*/

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