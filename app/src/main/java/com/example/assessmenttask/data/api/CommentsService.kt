package com.example.assessmenttask.data.api

import com.example.assessmenttask.data.model.Comments
import retrofit2.Call
import retrofit2.http.GET

interface CommentsService {
    @GET("comments")
    fun getCommentsList () : Call<List<Comments>>
}