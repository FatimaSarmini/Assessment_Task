package com.example.assessmenttask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "commentsTable")
data class Comments (
    @PrimaryKey
    @SerializedName("id")
    var id: Int,

    @ColumnInfo(name = "postrId")
    @SerializedName("postId")
    var postId: Int,

    @ColumnInfo(name = "email")
    @SerializedName("email")
    var email: String?,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String?,

    @ColumnInfo(name = "body")
    @SerializedName("body")
    var body: String?,

)