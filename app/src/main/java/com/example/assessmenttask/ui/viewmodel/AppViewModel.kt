package com.example.assessmenttask.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase
import com.example.assessmenttask.data.model.Posts
import com.example.assessmenttask.database.AppDatabase.Companion.getDatabase
import com.example.assessmenttask.database.AppRepository

class AppViewModel(application: Application): AndroidViewModel(application) {

    private val repository: AppRepository
    private var readAll: LiveData<List<Posts>>

    init {
        val appDB = RoomDatabase.getDatabase(application).appDao()
        repository = AppRepository(appDB)
        readAll =repository.getAllPosts()
    }
}