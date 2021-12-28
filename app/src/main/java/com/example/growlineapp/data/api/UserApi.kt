package com.example.growlineapp.data.api

import com.example.growlineapp.data.model.LoginResult
import com.example.growlineapp.data.model.Post
import com.example.growlineapp.data.model.UserProfile
import okhttp3.Response
import retrofit2.http.*

interface UserApi {
    @GET("user_profile")
    suspend fun getUserProfile(
        @QueryMap queryMap : Map<String, String>
    ):retrofit2.Call<UserProfile>

    @GET("login")
    suspend fun loginCheck(
        @QueryMap queryMap: Map<String, String>
    ):retrofit2.Call<LoginResult>

    @FormUrlEncoded
    @POST("signup")
    suspend fun signUp(
        @QueryMap queryMap: Map<String, String>
    ):retrofit2.Call<LoginResult>

    @GET("post")
    suspend fun getPostlist(

    ):retrofit2.Call<Post>
}