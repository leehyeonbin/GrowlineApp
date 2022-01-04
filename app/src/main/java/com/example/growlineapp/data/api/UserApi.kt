package com.example.growlineapp.data.api

import com.example.growlineapp.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface UserApi {
    @GET("user_info")
    suspend fun getUserProfile(
        @QueryMap query: Map<String, String>
    ): Response<UserProfile>

    @GET("login")
    suspend fun loginCheck(
        @QueryMap query: Map<String, String>
    ): Response<LoginResult>

    @FormUrlEncoded
    @POST("sign_up")
    suspend fun signUp(
        @QueryMap query: Map<String, String>
    ): Response<LoginResult>


    @GET("shop")
    suspend fun getStore(
        @QueryMap query: Map<String, String>
    ): Response<ShopResult>

}