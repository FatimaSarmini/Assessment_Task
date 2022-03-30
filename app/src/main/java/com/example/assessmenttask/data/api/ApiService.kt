package com.example.assessmenttask.data.api

import android.R
import com.example.assessmenttask.data.model.*
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getPostList () : Call<List<Posts>>

}