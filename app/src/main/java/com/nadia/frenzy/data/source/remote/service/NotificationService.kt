package com.nadia.frenzy.data.source.remote.service

import com.nadia.frenzy.data.DEFAULT_QUERY_PAGE_NUM
import com.nadia.frenzy.data.DEFAULT_QUERY_PAGE_SIZE
import com.nadia.frenzy.data.Notification
import retrofit2.Response
import retrofit2.http.*

interface NotificationService {

    @GET("notifications/")
    suspend fun getUserNotifications(
        @Header("authorization") token: String,
        @Query("id") userId: String,
        @Query("page") page: Int = DEFAULT_QUERY_PAGE_NUM,
        @Query("page_size") page_size : Int = DEFAULT_QUERY_PAGE_SIZE
    ): List<Notification>

    @PUT("notifications/open/{id}")
    suspend fun makeNotificationOpened(
        @Header("authorization") token: String,
        @Path("id") id: String
    ): Response<String>
}