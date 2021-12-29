package com.example.growlineapp.data.model

data class Post_list(
    val post : ArrayList<Post>
)

data class Post(
    val title : String,
    val content : String,
    val date : String,
    val view : String
)