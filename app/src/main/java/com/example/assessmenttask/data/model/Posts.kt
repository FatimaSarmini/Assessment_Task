package com.example.assessmenttask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class Posts(
    @PrimaryKey
    var id: Int,
    var body: String,
    var title: String,
    var userId: Int,
    var isFavorite: Boolean = false,

    )