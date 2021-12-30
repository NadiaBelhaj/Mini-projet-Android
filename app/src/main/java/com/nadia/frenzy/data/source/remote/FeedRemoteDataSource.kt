package com.nadia.frenzy.data.source.remote

import com.nadia.frenzy.data.Feed
import com.nadia.frenzy.data.source.FeedDataSource
import com.nadia.frenzy.data.source.remote.service.FeedService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class FeedRemoteDataSource @Inject constructor (
    private val feedService: FeedService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : FeedDataSource {

    override suspend fun getUserFeed(id: String, userId: String, page: Int) : Result<List<Feed>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.success(feedService.getUserFeed(id, userId, page))
        } catch (e : Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getHomeFeed(userId: String, page: Int): Result<List<Feed>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.success(feedService.getHomeFeed(userId, page))
        } catch (e : Exception) {
            Result.failure(e)
        }
    }
}