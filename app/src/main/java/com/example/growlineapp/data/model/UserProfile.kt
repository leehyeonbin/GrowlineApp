package com.example.growlineapp.data.model

import com.google.gson.annotations.SerializedName

data class UserProfile(
    @SerializedName("user_id")
    val user_id : String,
    @SerializedName("user_summary")
    val user_summary : String,
    @SerializedName("user_koin")
    val user_koin : Int,
    @SerializedName("result")
    val login_result : Boolean
)