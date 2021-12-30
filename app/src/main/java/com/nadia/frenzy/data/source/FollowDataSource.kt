package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.FollowData
import retrofit2.Response

interface FollowDataSource {

    suspend fun followUser(token : String, followData: FollowData) : Result<Response<String>>

    suspend fun unFollowUser(token : String, followData: FollowData) : Result<Response<String>>
}