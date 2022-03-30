package com.example.assessmenttask.data.api

import android.R
import com.example.assessmenttask.data.model.*
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getPostList () : Call<List<Posts>>

    @GET("comments")
    fun  getCommentList () : Call<List<Comments>>


    @GET("posts")
    suspend fun get_Post_List () : List<Posts>

    @GET("comments")
    suspend fun get_Comment_List () : List<Comments>


}