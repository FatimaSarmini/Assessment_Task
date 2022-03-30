package com.example.assessmenttask.data.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Users(

    @PrimaryKey
    @SerializedName("id")
    var id: Int,

    @ColumnInfo(name = "username")
    @SerializedName("username")
    var username: String?
)
