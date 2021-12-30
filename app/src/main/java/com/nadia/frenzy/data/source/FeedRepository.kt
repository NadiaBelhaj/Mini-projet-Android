package com.nadia.frenzy.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nadia.frenzy.data.Feed
import com.nadia.frenzy.data.source.remote.paging.FeedPagingDataSource
import com.nadia.frenzy.data.source.remote.paging.HomePagingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FeedRepository @Inject constructor(private val feedDataSource: FeedDataSource) {

    fun getUserFeed(id : String, userId : String) : Flow<PagingData<Feed>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { FeedPagingDataSource(feedDataSource, id, userId) }).flow
    }

    fun getHomeFeed(userId : String) : Flow<PagingData<Feed>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { HomePagingDataSource(feedDataSource, userId) }).flow
    }
}