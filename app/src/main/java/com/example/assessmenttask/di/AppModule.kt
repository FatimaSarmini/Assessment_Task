package com.example.assessmenttask.di

import android.app.Application
import androidx.room.Room
import com.example.assessmenttask.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "news_article_database")
            .fallbackToDestructiveMigration()
            .build()
}