package com.example.growlineapp.data.model

import com.google.gson.annotations.SerializedName

data class UserProfile(
    @SerializedName("choose_sit")
    val choose_sit : Int,
    @SerializedName("coin")
    val coin : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("no_clean")
    val no_clean : Int,
    @SerializedName("outside")
    val outside : Int
)