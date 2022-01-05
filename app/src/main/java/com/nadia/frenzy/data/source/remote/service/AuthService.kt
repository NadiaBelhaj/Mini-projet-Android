package com.nadia.frenzy.data.source.remote.service

import com.nadia.frenzy.data.LoginData
import com.nadia.frenzy.data.RegisterData
import com.nadia.frenzy.data.SessionData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {

    @POST("users/login")
    @Headers("content-type: application/json")
    suspend fun login(@Body body: LoginData): Response<SessionData>

    @POST("users/register")
    @Headers("content-type: application/json")
    suspend fun register(@Body body: RegisterData): Response<SessionData>

    //@Body to pass the needed model to the API.
}