package com.nadia.frenzy.data.source.remote

import com.nadia.frenzy.data.LoginData
import com.nadia.frenzy.data.RegisterData
import com.nadia.frenzy.data.SessionData
import com.nadia.frenzy.data.source.AuthDataSource
import com.nadia.frenzy.data.source.remote.service.AuthService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authService: AuthService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthDataSource {

    override suspend fun login(body: LoginData): Result<Response<SessionData>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.success(authService.login(body))
        } catch (e : Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(body: RegisterData):Result<Response<SessionData>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.success(authService.register(body))
        } catch (e : Exception) {
            Result.failure(e)
        }
    }

}