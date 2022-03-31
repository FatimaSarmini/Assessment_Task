package com.example.assessmenttask.data.api

import com.example.assessmenttask.data.model.*
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPostList () : List<Posts>

    @GET("comments")
    suspend fun getCommentList () : List<Comments>


}