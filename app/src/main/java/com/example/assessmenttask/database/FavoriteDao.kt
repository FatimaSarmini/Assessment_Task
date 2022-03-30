package com.example.assessmenttask.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.assessmenttask.data.model.FavoriteList
import retrofit2.http.Query

@Dao
interface FavoriteDao {
    @Insert
    fun addData(favoriteList: FavoriteList)

//    @Query("SELECT * FROM favoritelist")
    fun getFavoriteData(): List<FavoriteList>


    @Delete
    fun delete(favoriteList: FavoriteList)
}