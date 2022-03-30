package com.example.assessmenttask.database

import com.example.assessmenttask.data.model.Posts
import javax.inject.Inject


class AppRepository(private val appDao: AppDao) {



    fun getPostById(id: Int): Posts {
        return appDao.getDataUserById(id)
    }

    fun updateRecord(post: Posts) {
        appDao.updateRecord(post)
    }

}