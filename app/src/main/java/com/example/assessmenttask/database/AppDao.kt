package com.example.assessmenttask.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.assessmenttask.data.model.Posts

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPosts(post: List<Posts>)

    @Query("SELECT * FROM allPostTable")
    fun getAllPosts(): LiveData<List<Posts>>

    @Query("SELECT * FROM allPostTable WHERE id = :id")
    fun getDataUserById(id: Int): Posts

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateRecord(post: Posts)

}