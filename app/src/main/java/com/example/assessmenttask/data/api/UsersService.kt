package com.example.assessmenttask.data.api

import com.example.assessmenttask.data.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface UsersService {
    @GET("users")
    fun getUsers () : Call<List<Users>>
}