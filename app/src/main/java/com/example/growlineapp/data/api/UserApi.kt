package com.example.growlineapp.data.api

import com.example.growlineapp.data.model.LoginResult
import com.example.growlineapp.data.model.UserProfile
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface UserApi {
    @GET("user_profile")
    suspend fun getUserProfile(
        @QueryMap queryMap : Map<String, String>
    ):retrofit2.Call<UserProfile>

    @GET("login")
    suspend fun loginCheck(
        @QueryMap queryMap: Map<String, String>
    ):retrofit2.Call<LoginResult>
}