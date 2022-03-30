package com.example.assessmenttask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "allPostTable")
data class Posts(
    @ColumnInfo(name = "body")
    @SerializedName("body")
    var body: String?,
    @PrimaryKey
    @SerializedName("id")
    var id: Int,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String?,
    @ColumnInfo(name = "userId")
    @SerializedName("userId")
    var userId: Int
)