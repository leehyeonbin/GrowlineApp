package com.example.growlineapp.data.model

import com.google.gson.annotations.SerializedName

data class ShopResult(
    @SerializedName("result")
    val result : String,
    @SerializedName("current_coin")
    val coin : Int,
    @SerializedName("choose_sit")
    val user_sit : Int,
    @SerializedName("outside")
    val user_outside : Int,
    @SerializedName("no_clean")
    val user_no_clean : Int
)
