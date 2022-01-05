package com.nadia.frenzy.data.source.remote.service


//Send Parameters And Multiple Media Content Use MultipartBody.
// okhttp3.FormBody is used to send string parameters.
// okhttp3.RequestBody is used to send multiple media content such as file and json string.

import com.nadia.frenzy.data.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    @GET("users/{id}")
    suspend fun getUserById(
        @Path("id") id: String,
        @Query("userId") userId: String
    ): User

    @GET("users/")
    suspend fun getUserList(
        @Query("page") page: Int = DEFAULT_QUERY_PAGE_NUM,
        @Query("page_size") page_size : Int = DEFAULT_QUERY_PAGE_SIZE
    ): List<User>

    @GET("users/search")
    suspend fun getUsersSearch(
        @Query("q") query: String,
        @Query("page") page : Int = DEFAULT_QUERY_PAGE_NUM,
        @Query("page_size") page_size : Int = DEFAULT_QUERY_PAGE_SIZE
    ): List<User>

    @Multipart
    @PUT("users/avatar")
    suspend fun updateUserAvatar(
        @Part("email") requestBody: RequestBody,
        @Part avatar : MultipartBody.Part
    ): Response<String>

    @Multipart
    @PUT("users/wallpaper")
    suspend fun updateUserWallpaper(
        @Part("email") request: RequestBody,
        @Part wallpaper : MultipartBody.Part
    ): Response<String>

    @PUT("users/status")
    suspend fun updateUserStatus(
        @Header("authorization") token : String,
        @Body statusBody: StatusBody
    ) : Response<String>

    @PUT("users/address")
    suspend fun updateUserAddress(
        @Header("authorization") token : String,
        @Body locationBody: LocationBody
    ) : Response<String>

    @PUT("users/color")
    suspend fun updateUserColor(
        @Header("authorization") token : String,
        @Body colorBody: ColorBody
    ) : Response<String>

    @PUT("users/password")
    suspend fun updateUserPassword(
        @Header("authorization") token : String,
        @Body passwordBody: PasswordBody
    ) : Response<String>

    @PUT("users/games")
    suspend fun updateUserGames(
        @Header("authorization") token : String,
        @Body gamesBody: Game
    ) : Response<String>

    @PUT("users/platforms")
    suspend fun updateUserPlatforms(
        @Header("authorization") token : String,
        @Body platformsBody: Platform
    ) : Response<String>
}
