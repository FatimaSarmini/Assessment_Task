package com.example.assessmenttask.database

import androidx.room.withTransaction
import com.example.assessmenttask.data.api.ApiService
import com.example.assessmenttask.data.model.Comments
import com.example.assessmenttask.data.model.Posts
import java.lang.Exception
import javax.inject.Inject


class AppRepository @Inject constructor(
    private val api: ApiService,
    private val db: AppDatabase
) {
    private val dao = db.appDao()

    suspend fun getComments(): List<Comments> {
        return api.getCommentList()
    }

    suspend fun getPosts(): List<Posts> {
        return try {
            remotePosts()
        } catch (e: Exception) {
            localPosts()
        }
    }

    private suspend fun remotePosts(): List<Posts> {
        val posts = api.getPostList()
        val favoritePosts = dao.getFavorites()
        val newPosts = posts.map { serverPost ->
            val isFavorite = favoritePosts.any { favoritePost ->
                serverPost.id == favoritePost.id
            }

            Posts(
                id = serverPost.id,
                body = serverPost.body,
                title = serverPost.title,
                userId = serverPost.userId,
                isFavorite = isFavorite
            )
        }

        db.withTransaction {
            dao.deleteAllPosts()
            dao.insertPosts(newPosts)
        }

        return newPosts
    }

    private suspend fun localPosts(): List<Posts> {
        return dao.getAllPosts()
    }

    suspend fun getFavoritePost(): List<Posts> {
        return dao.getFavorites()
    }

    suspend fun getPost(id: Int): Posts {
        return dao.getPost(id)
    }

    suspend fun updatePost(post: Posts) {
        dao.updatePost(post)
    }
}
