package com.example.assessmenttask.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.assessmenttask.data.model.Posts

@Dao
interface AppDao {

    @Query("SELECT * FROM posts_table")
    suspend fun getAllPosts(): List<Posts>

    @Query("SELECT * FROM posts_table WHERE id = :id")
    suspend fun getPost(id: Int): Posts

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePost(post: Posts)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(insertPosts: List<Posts>)

    @Query("SELECT * FROM posts_table WHERE isFavorite = :liked")
    suspend fun getFavorites(liked: Boolean = true): List<Posts>

    @Query("DELETE FROM posts_table")
    suspend fun deleteAllPosts()

}