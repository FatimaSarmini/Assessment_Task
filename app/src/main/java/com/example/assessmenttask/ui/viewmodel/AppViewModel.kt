package com.example.assessmenttask.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.assessmenttask.data.model.Posts
import com.example.assessmenttask.database.AppDatabase

class AppViewModel(var application:Application): ViewModel() {

        private val db:AppDatabase = AppDatabase.getDatabase(application)
        internal val allPosts : LiveData<List<Posts>> = db.appDao().getAllPosts()

        fun insert(post:List<Posts>){
            db.appDao().insertPosts(post)
        }
    }