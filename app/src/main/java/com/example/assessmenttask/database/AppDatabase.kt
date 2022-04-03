package com.example.assessmenttask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assessmenttask.data.model.Posts


@Database(entities = [Posts::class], version = 1)

abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao() : AppDao

}