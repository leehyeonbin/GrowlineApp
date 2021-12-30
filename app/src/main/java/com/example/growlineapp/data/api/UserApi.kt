package com.example.growlineapp.data.api

import com.example.growlineapp.data.model.*
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
    @POST("sign_up")
    suspend fun signUp(
        @QueryMap queryMap: Map<String, String>
    ):retrofit2.Call<LoginResult>

    @GET("comunity")
    suspend fun getPostList(

    ):retrofit2.Call<Post_list>

    @GET("shop")
    suspend fun getStore(
        @QueryMap queryMap: Map<String, String>
    ):retrofit2.Call<ShopResult>

}