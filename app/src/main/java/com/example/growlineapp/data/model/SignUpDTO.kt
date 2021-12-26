package com.example.growlineapp.data.model

import com.google.gson.annotations.SerializedName

data class SignUpDTO(
    @SerializedName("user_id")
    val user_id : String,
    @SerializedName("user_password")
    val user_password : String
)
