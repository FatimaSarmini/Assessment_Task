package com.example.assessmenttask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favTable")
data class FavList(
    @ColumnInfo(name = "post_id")
    val id: Int? = 0
)