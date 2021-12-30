package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.Feed

interface FeedDataSource {

    suspend fun getUserFeed(id : String, userId : String, page : Int) : Result<List<Feed>>

    suspend fun getHomeFeed(userId : String, page : Int) : Result<List<Feed>>
}