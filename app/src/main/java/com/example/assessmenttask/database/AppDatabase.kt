package com.example.assessmenttask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assessmenttask.data.model.Posts


@Database(entities = [Posts::class], version = 1, exportSchema = false)

abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao() : AppDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "APP_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }
}