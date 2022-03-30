package com.example.assessmenttask.ui.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessmenttask.data.model.Comments
import com.example.assessmenttask.database.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val repository: AppRepository
): ViewModel(), LifecycleObserver {

    private val commentsFlow = MutableStateFlow<List<Comments>>(emptyList())
    val comment: Flow<List<Comments>> = commentsFlow


    init {
        viewModelScope.launch {
            val comments = repository.getComments()
            commentsFlow.value = comments
        }
    }

    fun updateFavorite(id: Int) {
        viewModelScope.launch {
            val post = repository.getPost(id)
            val updatedPost = post.copy(isFavorite = !post.isFavorite)
            repository.updatePost(updatedPost)
        }
    }
}