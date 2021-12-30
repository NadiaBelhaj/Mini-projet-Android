package com.nadia.frenzy.data.source

import com.nadia.frenzy.data.LoginData
import com.nadia.frenzy.data.RegisterData
import com.nadia.frenzy.data.SessionData
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authDataSource: AuthDataSource) {

    suspend fun login(body : LoginData) : Result<Response<SessionData>> {
        return authDataSource.login(body)
    }

    suspend fun register(body : RegisterData) : Result<Response<SessionData>> {
        return authDataSource.register(body)
    }
}