package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.LoginData
import com.nadia.frenzy.data.RegisterData
import com.nadia.frenzy.data.SessionData
import retrofit2.Response

interface AuthDataSource {

    suspend fun login(body : LoginData) : Result<Response<SessionData>>

    suspend fun register(body : RegisterData) : Result<Response<SessionData>>

}